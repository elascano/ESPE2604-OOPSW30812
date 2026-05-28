class Tax:
    
    @staticmethod
    def computeIva(amount, taxPercentage):
        taxValue = amount * taxPercentage / 100
        return taxValue

    @staticmethod
    def computeTotal(amount, taxPercentage):
        totalValue = amount + Tax.computeIva(amount, taxPercentage)
        return totalValue