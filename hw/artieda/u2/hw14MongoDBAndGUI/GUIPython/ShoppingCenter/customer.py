class Customer:
    def __init__(self, id_customer, first_name, last_name, gender, money_spent, age, type_of_customer, hobbies):
        self.id = id_customer
        self.firstName = first_name
        self.lastName = last_name
        self.gender = gender
        self.moneySpent = money_spent
        self.age = age
        self.typeOfCustomer = type_of_customer
        self.hobbies = hobbies

    def __str__(self):
        return f"Customer{{id={self.id}, firstName={self.firstName}, lastName={self.lastName}, gender={self.gender}, moneySpent={self.moneySpent}, age={self.age}, typeOfCustomer={self.typeOfCustomer}, hobbies={self.hobbies}}}"
