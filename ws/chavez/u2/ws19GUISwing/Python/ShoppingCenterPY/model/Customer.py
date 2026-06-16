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
    def get_id(self):
        return self._id
    def get_first_name(self):
        return self._first_name
    def get_last_name(self):
        return self._last_name
    def get_gender(self):
        return self._gender
    def get_money_spent(self):
        return self._money_spent    
    def get_age(self):
        return self._age
    def get_type_of_customer(self):
        return self._type_of_customer
    def get_hobbies(self):
        return self._hobbies
    def set_id(self, id_customer):
        self._id = id_customer
    def set_first_name(self, first_name):
        self._first_name = first_name
    def set_last_name(self, last_name):
        self._last_name = last_name
    def set_gender(self, gender):
        self._gender = gender
    def set_money_spent(self, money_spent):
        self._money_spent = money_spent

    def __str__(self):
        return f"Customer[ID: {self._id}, Name: {self._first_name} {self._last_name}, Gender: {self._gender}, Money Spent: {self._money_spent}, Age: {self._age}, Type: {self._type_of_customer}, Hobbies: {', '.join(self._hobbies)}]"   