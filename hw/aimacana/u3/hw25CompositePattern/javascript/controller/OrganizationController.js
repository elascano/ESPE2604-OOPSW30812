class OrganizationController {
    constructor(model, view) {
        this.model = model;
        this.view = view;
    }
    
    updateView() {
        this.view.printOrganization(this.model.stateName());
    }
}
module.exports = OrganizationController;
