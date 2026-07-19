from ec_edu_espe.model.supervisor import Supervisor

class President(Supervisor):
    def get_role(self) -> str:
        return "President"