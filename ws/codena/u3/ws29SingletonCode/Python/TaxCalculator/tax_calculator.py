from tax import Tax

iva = Tax.getInstance()

anotherTax = Tax.getInstance()

percentage = 0.15
price = 1000

iva.updateTaxPercentage(percentage)

calculatedPrice = iva.salesTotal(price)

print("The percentage is:", iva.getPercentage())
print("The price is:", f"{calculatedPrice}$")
