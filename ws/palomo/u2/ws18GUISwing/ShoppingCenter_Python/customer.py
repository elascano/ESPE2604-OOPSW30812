"""
customer.py
Modelo de cliente para el Shopping Center
@author Cristian (convertido a Python)
"""


class Customer:
    def __init__(self, id: int, first_name: str, last_name: str,
                 gender: str, money_spent: float, age: int,
                 type_customer: str, hobbies: list = None):
        self.__id = id
        self.__first_name = first_name
        self.__last_name = last_name
        self.__gender = gender
        self.__money_spent = money_spent
        self.__age = age
        self.__type_customer = type_customer
        self.__hobbies = hobbies if hobbies is not None else []

    # --- Getters ---
    def get_id(self) -> int:
        return self.__id

    def get_first_name(self) -> str:
        return self.__first_name

    def get_last_name(self) -> str:
        return self.__last_name

    def get_gender(self) -> str:
        return self.__gender

    def get_money_spent(self) -> float:
        return self.__money_spent

    def get_age(self) -> int:
        return self.__age

    def get_type_customer(self) -> str:
        return self.__type_customer

    def get_hobbies(self) -> list:
        return self.__hobbies

    # --- Setters ---
    def set_id(self, id: int):
        self.__id = id

    def set_first_name(self, first_name: str):
        self.__first_name = first_name

    def set_last_name(self, last_name: str):
        self.__last_name = last_name

    def set_gender(self, gender: str):
        self.__gender = gender

    def set_money_spent(self, money_spent: float):
        self.__money_spent = money_spent

    def set_age(self, age: int):
        self.__age = age

    def set_type_customer(self, type_customer: str):
        self.__type_customer = type_customer

    def set_hobbies(self, hobbies: list):
        self.__hobbies = hobbies

    def __str__(self):
        return (f"Customer {{ id={self.__id}, firstName={self.__first_name}, "
                f"lastName={self.__last_name}, gender={self.__gender}, "
                f"moneySpent={self.__money_spent}, age={self.__age}, "
                f"typeCustomer={self.__type_customer}, hobbies={self.__hobbies} }}")
