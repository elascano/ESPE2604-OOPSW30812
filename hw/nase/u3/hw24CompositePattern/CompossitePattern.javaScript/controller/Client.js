//Jennyfer Nase

export class Client {
    static employee = null;

    static doClientTasks() {
        if (Client.employee !== null) {
            Client.employee.stateName();
        } else {
            console.log("No employee assigned to the client.");
        }
    }
}