from model.food import Food


class FoodController:

    def create_food(self, id, description):

        food = Food(id, description)

        return food