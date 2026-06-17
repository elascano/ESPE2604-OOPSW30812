class Customer:
    def __init__(self, id_customer, first_name, last_name, gender, money_spent, age, type_of_customer, hobbies):
        self._id = id_customer
        self._first_name = first_name
        self._last_name = last_name
        self._gender = gender
        self._money_spent = money_spent
        self._age = age
        self._type_of_customer = type_of_customer
        self._hobbies = hobbies

    def get_id(self): return self._id
    def set_id(self, value): self._id = value

    def get_first_name(self): return self._first_name
    def set_first_name(self, value): self._first_name = value

    def get_last_name(self): return self._last_name
    def set_last_name(self, value): self._last_name = value

    def get_gender(self): return self._gender
    def set_gender(self, value): self._gender = value

    def get_money_spent(self): return self._money_spent
    def set_money_spent(self, value): self._money_spent = value

    def get_age(self): return self._age
    def set_age(self, value): self._age = value

    def get_type_of_customer(self): return self._type_of_customer
    def set_type_of_customer(self, value): self._type_of_customer = value

    def get_hobbies(self): return self._hobbies
    def set_hobbies(self, value): self._hobbies = value

    def __str__(self):
        return f"Customer{{id={self._id}, firstName={self._first_name}, lastName={self._last_name}, gender={self._gender}, moneySpent={self._money_spent}, age={self._age}, typeOfCustomer={self._type_of_customer}, hobbies={self._hobbies}}}"