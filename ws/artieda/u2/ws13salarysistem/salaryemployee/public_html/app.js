/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

const EmployeeModel = require('./ec.edu.espe.employeesalary.model/EmployeeModel');

const EmployeeView = require('./ec.edu.espe.employeesalary.view/EmployeeView');

const EmployeeController = require('./ec.edu.espe.employeesalary.controller/EmployeeController');

const model = new EmployeeModel('./data/employees.json');

const view = new EmployeeView();

const controller = new EmployeeController(model, view);

// START PROGRAM
controller.addEmployeeNames();
