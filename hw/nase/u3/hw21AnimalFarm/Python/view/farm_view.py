class FarmView:
    @staticmethod
    def show_welcome():
        print("=" * 50)
        print("  FARM MANAGEMENT SYSTEM  ")
        print("=" * 50)

    @staticmethod
    def show_animal_info(info: dict):
        print(f"\n[Animal ID: {info['id']}] Tipo: {info['type']} | Raza: {info['breed']}")
        print(f" -> Edad: {info['age_months']} meses | Peso: {info['weight']} kg")
        if info.get('extra'):
            print(f" -> Detalles: {info['extra']}")

    @staticmethod
    def show_action_result(action_name: str, result: str):
        print(f" -> {action_name}: {result}")