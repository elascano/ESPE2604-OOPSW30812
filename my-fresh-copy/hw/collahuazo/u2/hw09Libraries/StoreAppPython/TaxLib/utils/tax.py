"""
@author: Collahuazo Brandon, CodeBros, @ESPE
"""

class Tax:
    def computeIva(amount, taxPorcentage):
        taxValue = amount * taxPorcentage / 100
        return taxValue
    
    def computeTotal(amount, taxPorcentage):
        totalValue = amount + Tax.computeIva(amount, taxPorcentage)
        return totalValue