class Tax:

    # Variable that stores the single instance (Singleton)
    __instance = None

    # Singleton Constructor
    def __new__(cls):
        if cls.__instance is None:
            cls.__instance = super().__new__(cls)
            cls.__instance.percentage = 15.0
        return cls.__instance

    def updateTaxPercentage(self, p):
        self.percentage = p

    def getPercentage(self):
        return self.percentage
    
    def salesTotal(self, amount):
        return amount + (amount * self.percentage / 100)