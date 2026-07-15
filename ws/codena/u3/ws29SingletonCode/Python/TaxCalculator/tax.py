class Tax:
    __instance = None

    def __new__(cls):
        if cls.__instance is None:
            print("\nInitializing instance\n")
            cls.__instance = super().__new__(cls)
            cls.__instance.percentage = 0
        return cls.__instance

    @staticmethod
    def getInstance():
        return Tax()

    def updateTaxPercentage(self, p):
        self.percentage = p

    def getPercentage(self):
        return self.percentage

    def salesTotal(self, price):
        return price * self.percentage