import { Client } from "../controller/Client";
import { Clerk } from "../model/Clerk";
import { Manager } from "../model/Manager";
import { President } from "../model/President";
import { Supervisor } from "../model/Supervisor";
import { Teller } from "../model/Teller";

function main(): void {
    // Hojas
    const clerk1 = new Clerk("Ana");
    const clerk2 = new Clerk("Luis");
    const teller1 = new Teller("Marta");

    // Compuestos
    const supervisor = new Supervisor("Carlos");
    supervisor.addEmployee(clerk1);
    supervisor.addEmployee(clerk2);
    supervisor.addEmployee(teller1);

    const manager = new Manager("Sofia");
    manager.addEmployee(supervisor);

    const president = new President("Jorge");
    president.addEmployee(manager);

    // El Client solo conoce la raiz como un Employee
    const client = new Client(president);
    client.mostrarOrganigrama();
}

main();