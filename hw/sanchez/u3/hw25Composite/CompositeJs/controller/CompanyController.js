class CompanyController {

    constructor(organization, view) {
        this.organization = organization;
        this.view = view;
    }

    displayOrganization() {
        this.view.showOrganization(this.organization);
    }
}

module.exports = CompanyController;