class CompanyController:

    def __init__(self, organization, view):
        self.organization = organization
        self.view = view

    def display_organization(self):
        self.view.show_organization(self.organization)