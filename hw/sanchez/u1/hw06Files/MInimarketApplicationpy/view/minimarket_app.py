import sys
import os
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from model.product import Product
from model.promotional_bundle import PromotionalBundle
from model.cash_register import CashRegister

def system_expiration_alerts():
    print("\n   SISTEMA DE ALERTAS DE CADUCIDAD\n")
    products = Product.read_csv("data/products.csv")
    for product in products:
        product.calculate_and_assign_discount()
    print("\nREPORTE DE CADUCIDAD\n")
    for product in products:
        product.show_alert()
    print("\nGENERANDO ARCHIVO JSON ")
    Product.export_to_json(products, "data/productos.json")
    print("\nGRACIAS")

def system_promotional_bundles():
    print("\n    SISTEMA DE PAQUETES PROMOCIONALES\n")
    products = Product.read_csv("data/products.csv")
    bundles = PromotionalBundle.read_csv("data/promotional_bundles.csv")
    product_map = Product.get_product_map(products)
    stock_map = Product.get_stock_map(products)
    print("\nValidando Paquetes\n")
    for bundle in bundles:
        bundle.calculate_profit_margin(product_map)
        print(f"\nPaquete: {bundle.name}")
        print(f"Precio: ${bundle.bundle_price:.2f}")
        print(f"Margen de ganancia: {bundle.profit_margin:.2f}%")
        print(f"Rentable: {'Si' if bundle.has_positive_profit() else 'No'}")
        print(f"Stock suficiente: {'Si' if bundle.has_enough_stock(stock_map) else 'No'}")
    print("\nGENERANDO ARCHIVO JSON")
    PromotionalBundle.export_to_json(bundles, "data/paquetes.json")
    print("\nGRACIAS")

def system_cash_register():
    print("\n    SISTEMA DE CAJA REGISTRADORA\n")
    starting_balance = float(input("Ingrese el balance inicial de la caja: $"))
    total_sales = float(input("Ingrese el total de ventas del dia: $"))
    security_withdrawals = float(input("Ingrese los retiros de seguridad (si no hay, ingrese 0): $"))
    cash_register = CashRegister(starting_balance, total_sales, security_withdrawals)
    physical_count = float(input("\nIngrese el conteo fisico del dinero en caja: $"))
    cash_register.set_physical_count(physical_count)
    cash_register.show_report()
    print("\nGENERANDO ARCHIVO JSON")
    cash_register.export_to_json("data/caja.json")
    print("\nGRACIAS")

def main():
    while True:
        print("\n      MINIMARKET APPLICATION\n")
        print("1. Sistema de Alertas de Caducidad")
        print("2. Sistema de Paquetes Promocionales")
        print("3. Sistema de Caja Registradora")
        print("4. Salir\n")
        option = input("Seleccione una opcion: ")
        try:
            option = int(option)
        except:
            print("\nOpcion no valida. Intente de nuevo.")
            continue
        if option == 1:
            system_expiration_alerts()
        elif option == 2:
            system_promotional_bundles()
        elif option == 3:
            system_cash_register()
        elif option == 4:
            print("\nGRACIAS POR USAR EL SISTEMA")
            break
        else:
            print("\nOpcion no valida. Intente de nuevo.")

if __name__ == "__main__":
    main()