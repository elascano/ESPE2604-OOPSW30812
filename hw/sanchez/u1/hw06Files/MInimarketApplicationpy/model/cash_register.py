import json

class CashRegister:
    def __init__(self, starting_balance: float, total_sales: float, security_withdrawals: float):
        self.starting_balance = starting_balance
        self.total_sales = total_sales
        self.security_withdrawals = security_withdrawals
        self.expected_balance = starting_balance + total_sales - security_withdrawals
        self.physical_count = 0.0
        self.discrepancy = 0.0

    def set_physical_count(self, physical_count: float):
        self.physical_count = physical_count
        self.discrepancy = self.physical_count - self.expected_balance

    def is_balanced(self) -> bool:
        return self.discrepancy == 0

    def get_surplus(self) -> float:
        return self.discrepancy if self.discrepancy > 0 else 0

    def get_shortage(self) -> float:
        return abs(self.discrepancy) if self.discrepancy < 0 else 0

    def show_report(self):
        print("\nCAJA REGISTRADORA\n")
        print(f"Balance inicial: ${self.starting_balance:.2f}")
        print(f"Total ventas: ${self.total_sales:.2f}")
        print(f"Retiros de seguridad: ${self.security_withdrawals:.2f}")
        print(f"Balance esperado: ${self.expected_balance:.2f}")
        print(f"Conteo fisico: ${self.physical_count:.2f}")
        print("\n VERIFICACION")
        if self.is_balanced():
            print("CAJA CUADRADA - No hay discrepancias")
        elif self.discrepancy > 0:
            print(f"Sobra ${self.get_surplus():.2f}")
            print("Revisar si hubo errores en vueltos o ventas")
        else:
            print(f"Falta ${self.get_shortage():.2f}")
            print("Revisar posibles robos o errores en ventas")

    def export_to_json(self, file_path: str):
        data = {"startingBalance": self.starting_balance, "totalSales": self.total_sales,
                "securityWithdrawals": self.security_withdrawals, "expectedBalance": self.expected_balance,
                "physicalCount": self.physical_count, "discrepancy": self.discrepancy}
        try:
            with open(file_path, 'w', encoding='utf-8') as f:
                json.dump(data, f, indent=4, ensure_ascii=False)
            print(f"Archivo JSON de caja generado: {file_path}")
        except Exception as e:
            print(f"Error al generar JSON: {e}")