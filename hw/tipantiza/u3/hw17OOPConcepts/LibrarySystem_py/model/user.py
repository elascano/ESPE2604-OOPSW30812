from model.person import Person

class User(Person):
    def __init__(self, id: str = None, first_name: str = None,
                 last_name: str = None, email: str = None,
                 user_type: str = None):
        super().__init__(id, first_name, last_name, email)
        self._user_type = user_type
        self._active_loans = 0
        self._loan_history = []
    
    @property
    def user_type(self):
        return self._user_type
    
    @user_type.setter
    def user_type(self, value):
        self._user_type = value
    
    @property
    def active_loans(self):
        return self._active_loans
    
    @active_loans.setter
    def active_loans(self, value):
        self._active_loans = value
    
    @property
    def loan_history(self):
        return self._loan_history
    
    @loan_history.setter
    def loan_history(self, value):
        self._loan_history = value
    
    def get_person_type(self) -> str:
        return "User"
    
    def add_loan(self, book_id: str) -> None:
        self._loan_history.append(book_id)
        self._active_loans += 1
    
    def return_loan(self, book_id: str) -> None:
        if book_id in self._loan_history:
            self._loan_history.remove(book_id)
            self._active_loans -= 1
    
    def can_borrow(self) -> bool:
        return self._active_loans < 5
    
    def __str__(self):
        return f"User: {super().__str__()}, Type: {self._user_type}"