from ec_edu_espe.model.employee import Supervisor

class Manager(Supervisor):

    def get_role(self) -> str:
        return "Manager"