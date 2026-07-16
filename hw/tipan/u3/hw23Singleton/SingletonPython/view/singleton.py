from model.tax import Tax

def main():
    tax = Tax()
    tax.update_tax_percentage(15)
    subtotal = 100
    print(f"Tax percentage: {tax.get_percentage()}%")
    print(f"Subtotal: ${subtotal}")
    print(f"Total: ${tax.sales_total(subtotal)}")

if __name__ == "__main__":
    main()