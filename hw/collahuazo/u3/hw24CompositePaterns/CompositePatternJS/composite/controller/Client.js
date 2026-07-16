/**
 * Cliente del patron Composite.
 * Trabaja con la jerarquia a traves de la interfaz comun (Employee),
 * sin necesidad de distinguir entre hojas y compuestos.
 */
class Client {
  // This class relates to a specific Employee
  static employee = null;

  static doClientTasks() {
    // Do work with this employee
    Client.employee.stateName();
  }
}

module.exports = { Client };
