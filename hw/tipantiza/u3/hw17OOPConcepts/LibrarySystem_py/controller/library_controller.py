from typing import List
import uuid
from datetime import datetime

from model.book import Book
from model.user import User
from model.loan import Loan
from model.interfaces.manageable import IManageable
from utils.mongodb_connection import MongoDBConnection

class LibraryController(IManageable[Book]):
    def __init__(self):
        self._books = []
        self._users = []
        self._loans = []
        self._db = MongoDBConnection()
        self._load_initial_data()
    
    def add(self, book: Book) -> None:
        if not book.id or book.id == "":
            book.id = str(uuid.uuid4())
        self._books.append(book)
        self._db.insert_document(MongoDBConnection.BOOKS_COLLECTION, book)
    
    def remove(self, id: str) -> None:
        self._books = [book for book in self._books if book.id != id]
        self._db.delete_document(MongoDBConnection.BOOKS_COLLECTION, id)
    
    def find(self, id: str) -> Book:
        for book in self._books:
            if book.id == id:
                return book
        return None
    
    def find_all(self) -> List[Book]:
        return self._books.copy()
    
    def update(self, book: Book) -> None:
        for i, existing_book in enumerate(self._books):
            if existing_book.id == book.id:
                self._books[i] = book
                self._db.update_document(MongoDBConnection.BOOKS_COLLECTION, book.id, book)
                break
    
    def add_user(self, user: User) -> None:
        if not user.id or user.id == "":
            user.id = str(uuid.uuid4())
        self._users.append(user)
        self._db.insert_document(MongoDBConnection.USERS_COLLECTION, user)
    
    def find_user(self, id: str) -> User:
        for user in self._users:
            if user.id == id:
                return user
        return None
    
    def find_all_users(self) -> List[User]:
        return self._users.copy()
    
    def remove_user(self, id: str) -> None:
        self._users = [user for user in self._users if user.id != id]
        self._db.delete_document(MongoDBConnection.USERS_COLLECTION, id)
    
    def update_user(self, user: User) -> None:
        for i, existing_user in enumerate(self._users):
            if existing_user.id == user.id:
                self._users[i] = user
                self._db.update_document(MongoDBConnection.USERS_COLLECTION, user.id, user)
                break
    
    def create_loan(self, user_id: str, book_id: str) -> None:
        user = self.find_user(user_id)
        book = self.find(book_id)
        
        self._validate_loan_request(user, book)
        
        loan = Loan(
            id=str(uuid.uuid4()),
            user_id=user_id,
            book_id=book_id,
            loan_date=datetime.now()
        )
        
        self._loans.append(loan)
        book.borrow()
        user.add_loan(book_id)
        
        self._db.insert_document(MongoDBConnection.LOANS_COLLECTION, loan)
        self.update(book)
        self.update_user(user)
    
    def _validate_loan_request(self, user: User, book: Book) -> None:
        if not user:
            raise Exception("User not found")
        if not book:
            raise Exception("Book not found")
        if not book.available:
            raise Exception(f"Book '{book.title}' is not available")
        if not user.can_borrow():
            raise Exception("User has reached maximum loan limit")
    
    def return_loan(self, loan_id: str) -> None:
        loan = None
        for l in self._loans:
            if l.id == loan_id:
                loan = l
                break
        
        if not loan:
            raise Exception("Loan not found")
        
        loan.return_date = datetime.now()
        loan.status = "RETURNED"
        
        book = self.find(loan.book_id)
        if book:
            book.return_book()
            self.update(book)
        
        user = self.find_user(loan.user_id)
        if user:
            user.return_loan(loan.book_id)
            self.update_user(user)
        
        self._db.update_document(MongoDBConnection.LOANS_COLLECTION, loan_id, loan)
    
    def find_all_loans(self) -> List[Loan]:
        return self._loans.copy()
    
    def find_active_loans(self) -> List[Loan]:
        return [loan for loan in self._loans if loan.status == "ACTIVE"]
    
    def find_loans_by_user(self, user_id: str) -> List[Loan]:
        return [loan for loan in self._loans if loan.user_id == user_id]
    
    def get_total_books(self) -> int:
        return len(self._books)
    
    def get_total_users(self) -> int:
        return len(self._users)
    
    def get_active_loans_count(self) -> int:
        return len([loan for loan in self._loans if loan.status == "ACTIVE"])
    
    def get_available_books_count(self) -> int:
        return len([book for book in self._books if book.available])
    
    def display_information(self, obj) -> None:
        if isinstance(obj, Book):
            print(f"Book: {obj.title} by {obj.author}")
        elif isinstance(obj, User):
            print(f"User: {obj.first_name} {obj.last_name}")
        elif isinstance(obj, Loan):
            print(f"Loan: {obj.id} - Status: {obj.status}")
    
    def _load_initial_data(self) -> None:
        try:
            self._load_books_from_database()
            self._load_users_from_database()
            self._load_loans_from_database()
            
            if not self._books and not self._users:
                self._create_sample_data()
        except Exception as e:
            print(f"Error loading initial data: {e}")
            self._create_sample_data()
    
    def _load_books_from_database(self) -> None:
        books_from_db = self._db.find_all_documents(
            MongoDBConnection.BOOKS_COLLECTION,
            Book
        )
        if books_from_db:
            self._books = books_from_db
            print(f"Loaded {len(self._books)} books from database")
    
    def _load_users_from_database(self) -> None:
        users_from_db = self._db.find_all_documents(
            MongoDBConnection.USERS_COLLECTION,
            User
        )
        if users_from_db:
            self._users = users_from_db
            print(f"Loaded {len(self._users)} users from database")
    
    def _load_loans_from_database(self) -> None:
        loans_from_db = self._db.find_all_documents(
            MongoDBConnection.LOANS_COLLECTION,
            Loan
        )
        if loans_from_db:
            self._loans = loans_from_db
            print(f"Loaded {len(self._loans)} loans from database")
    
    def _create_sample_data(self) -> None:
        print("Creating sample data...")
        
        book1 = Book(
            id=str(uuid.uuid4()),
            title="The Little Prince",
            author="Antoine de Saint-Exupery",
            isbn="978-3-16-148410-0",
            publication_year=1943,
            category="Fiction"
        )
        
        book2 = Book(
            id=str(uuid.uuid4()),
            title="One Hundred Years of Solitude",
            author="Gabriel Garcia Marquez",
            isbn="978-0-06-088328-7",
            publication_year=1967,
            category="Novel"
        )
        
        book3 = Book(
            id=str(uuid.uuid4()),
            title="The Art of Programming",
            author="Donald Knuth",
            isbn="978-0-201-03801-9",
            publication_year=1968,
            category="Computer Science"
        )
        
        self.add(book1)
        self.add(book2)
        self.add(book3)
        
        user1 = User(
            id=str(uuid.uuid4()),
            first_name="John",
            last_name="Doe",
            email="john.doe@email.com",
            user_type="STUDENT"
        )
        
        user2 = User(
            id=str(uuid.uuid4()),
            first_name="Jane",
            last_name="Smith",
            email="jane.smith@email.com",
            user_type="PROFESSOR"
        )
        
        self.add_user(user1)
        self.add_user(user2)
        
        print("Sample data created successfully")