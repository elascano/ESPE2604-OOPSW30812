from model.tea import Tea
from model.coffee import Coffee
from model.chocolate import Chocolate

class BeverageController:
    def prepare_all_beverages(self):
        tea = Tea()
        coffee = Coffee()
        chocolate = Chocolate()
        
        print("\nMaking tea ...")
        tea.prepare_recipe()
        
        print("\nMaking coffee ...")
        coffee.prepare_recipe()
        
        print("\nMaking chocolate ...")
        chocolate.prepare_recipe()