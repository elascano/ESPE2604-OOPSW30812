from service import ProductService

class ProductController:
    def __init__(self):
        self.service = ProductService()

    def get_catalog_list(self):
        return self.service.get_catalog()

    def get_cart_list(self):
        return self.service.get_cart()

    def buy_product(self, option_number):
        index = option_number - 1
        return self.service.add_to_cart(index)

    def get_cart_total(self):
        return self.service.calculate_total()