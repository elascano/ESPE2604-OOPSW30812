class Person:
    def __init__(self, person_id, name, email):
        self.person_id = person_id
        self.name = name
        self.email = email

    def to_dict(self):
        return {"_id": self.person_id, "name": self.name, "email": self.email}

class Product:
    def __init__(self, product_id, name, price):
        self.product_id = product_id
        self.name = name
        self.price = price

    def to_dict(self):
        return {"_id": self.product_id, "name": self.name, "price": self.price}

class Payment:
    def __init__(self, payment_id, payment_method, amount):
        self.payment_id = payment_id
        self.payment_method = payment_method
        self.amount = amount

    def to_dict(self):
        return {"_id": self.payment_id, "paymentMethod": self.payment_method, "amount": self.amount}