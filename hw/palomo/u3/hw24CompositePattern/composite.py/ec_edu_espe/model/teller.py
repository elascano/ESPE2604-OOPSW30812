from ec_edu_espe.model.employee import Employee


class Teller(Employee):
    """Leaf (Composite pattern): He cannot have subordinates."""

    def get_role(self) -> str:
        return "Teller"