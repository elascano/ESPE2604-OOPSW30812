import { Employee } from "../model/Employee";

export class Client {
    private root: Employee;

    constructor(root: Employee) {
        this.root = root;
    }

    /** Solicita el reporte completo de la organizacion desde la raiz. */
    mostrarOrganigrama(): void {
        this.root.stateName();
    }
}
