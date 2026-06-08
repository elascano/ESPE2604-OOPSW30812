#author Joel Sanchez <The_Softwarriors at ESPE>

import sys
import os


sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))


from model.Product import Product
from utils.Tax import Tax

class Store:
    @staticmethod
    def main():

        print(" STORE APP - TAXESLIB \n")

        
        id = 1
        descripcion = "compute"
        price = 100.0
        
        product = Product(id, descripcion, price)
        print("\n product --->" + str(product))
        
        id = 2
        descripcion = "mouse"
        price = 1000.0
        
        product2 = Product(id, descripcion, price)
        print("\n product 2 ---> " + str(product2))
        


if __name__ == "__main__":
    Store.main()

