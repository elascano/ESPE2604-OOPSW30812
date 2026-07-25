from typing import List

from model.loan import Loan
from model.interfaces.manageable import IManageable
from utils.mongodb_connection import MongoDBConnection

class LoanController(IManageable[Loan]):
    def __init__(self):
        self._loans = []
        self._db = MongoDBConnection()
        self._load_loans()
    
    def add(self, loan: Loan) -> None:
        self._loans.append(loan)
        self._db.insert_document(MongoDBConnection.LOANS_COLLECTION, loan)
    
    def remove(self, id: str) -> None:
        self._loans = [loan for loan in self._loans if loan.id != id]
        self._db.delete_document(MongoDBConnection.LOANS_COLLECTION, id)
    
    def find(self, id: str) -> Loan:
        for loan in self._loans:
            if loan.id == id:
                return loan
        return None
    
    def find_all(self) -> List[Loan]:
        return self._loans.copy()
    
    def update(self, loan: Loan) -> None:
        for i, existing_loan in enumerate(self._loans):
            if existing_loan.id == loan.id:
                self._loans[i] = loan
                self._db.update_document(MongoDBConnection.LOANS_COLLECTION, loan.id, loan)
                break
    
    def find_active_loans(self) -> List[Loan]:
        return [loan for loan in self._loans if loan.status == "ACTIVE"]
    
    def find_loans_by_user(self, user_id: str) -> List[Loan]:
        return [loan for loan in self._loans if loan.user_id == user_id]
    
    def find_overdue_loans(self) -> List[Loan]:
        return [loan for loan in self._loans if loan.is_overdue()]
    
    def _load_loans(self) -> None:
        loans_from_db = self._db.find_all_documents(
            MongoDBConnection.LOANS_COLLECTION,
            Loan
        )
        if loans_from_db:
            self._loans = loans_from_db
            print(f"Loaded {len(self._loans)} loans from database")