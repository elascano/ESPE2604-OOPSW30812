class MealView:
    def show_message(self, message):
        print(message)

    def get_user_input(self, prompt):
        print(prompt)
        try:
            return input()
        except EOFError:
            return "n"
