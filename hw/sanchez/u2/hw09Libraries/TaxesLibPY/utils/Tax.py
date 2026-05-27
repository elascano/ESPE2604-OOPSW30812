#author Joel Sanchez <The_Softwarriors at ESPE>

class Tax:
    @staticmethod
    def computeIva(amount, taxPorcentage):
        taxValue = amount * taxPorcentage / 100
        return taxValue
    
    @staticmethod
    def computeTotal(amount, taxPorcentage):
        totalValue = amount + Tax.computeIva(amount, taxPorcentage)
        return totalValue