class OrganizationController:
    def __init__(self, model, view):
        self.model = model
        self.view = view
        
    def update_view(self):
        self.view.print_organization(self.model.state_name())
