from datetime import datetime, timedelta

class Loan:
    MAX_LOAN_DAYS = 7
    FINE_PER_DAY = 0.50
    
    def __init__(self, id: str = None, user_id: str = None,
                 book_id: str = None, loan_date: datetime = None):
        self._id = id
        self._user_id = user_id
        self._book_id = book_id
        self._loan_date = loan_date if loan_date else datetime.now()
        self._return_date = None
        self._status = "ACTIVE"
        self._fine = 0.0
    
    @property
    def id(self):
        return self._id
    
    @id.setter
    def id(self, value):
        self._id = value
    
    @property
    def user_id(self):
        return self._user_id
    
    @user_id.setter
    def user_id(self, value):
        self._user_id = value
    
    @property
    def book_id(self):
        return self._book_id
    
    @book_id.setter
    def book_id(self, value):
        self._book_id = value
    
    @property
    def loan_date(self):
        return self._loan_date
    
    @loan_date.setter
    def loan_date(self, value):
        self._loan_date = value
    
    @property
    def return_date(self):
        return self._return_date
    
    @return_date.setter
    def return_date(self, value):
        self._return_date = value
        self._calculate_fine()
    
    @property
    def status(self):
        return self._status
    
    @status.setter
    def status(self, value):
        self._status = value
    
    @property
    def fine(self):
        return self._fine
    
    @fine.setter
    def fine(self, value):
        self._fine = value
    
    def _calculate_fine(self) -> None:
        if self._return_date and self._loan_date:
            diff = self._return_date - self._loan_date
            days = diff.days
            
            if days > self.MAX_LOAN_DAYS:
                self._fine = (days - self.MAX_LOAN_DAYS) * self.FINE_PER_DAY
            else:
                self._fine = 0.0
    
    def is_overdue(self) -> bool:
        if not self._return_date:
            now = datetime.now()
            diff = now - self._loan_date
            days = diff.days
            return days > self.MAX_LOAN_DAYS
        return False
    
    def __str__(self):
        return f"Loan: {self._id} - Status: {self._status}"