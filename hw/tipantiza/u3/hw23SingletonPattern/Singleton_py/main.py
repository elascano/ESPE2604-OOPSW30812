from tax import Tax


def main():
    tax = Tax()

    tax.update_tax_percentage(15.0)

    sale = 100.0

    print(f"Sale: ${sale}")
    print(f"Tax Percentage: {tax.get_percentage()}%")
    print(f"Total: ${tax.sales_total(sale)}")


if __name__ == "__main__":
    main()