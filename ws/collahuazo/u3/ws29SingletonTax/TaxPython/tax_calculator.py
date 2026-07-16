from tax import Tax
tax=Tax()
tax.update_tax_percentage(0.15)
print(f"Tax: {tax.percentage*100:.2f}%")
print(f"Total: ${tax.sales_total(100):.2f}")
