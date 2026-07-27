export default class Client {

    constructor(employee) {
        this.employee = employee;
    }

    showOrganization() {
        this.employee.stateName();
    }
}