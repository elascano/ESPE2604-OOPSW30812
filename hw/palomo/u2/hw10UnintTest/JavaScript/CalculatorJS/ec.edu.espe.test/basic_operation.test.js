/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
const BasicOperation = require('../ec.edu.espe.controller/basic_operation');
describe('TestBasicOperation', () => {
    
    test('test_add parameterized', () => {
        const add_cases = [
            [15.72, 42.18, 57.9],      
            [-10.5, 25.3, 14.8],      
            [100.45, -50.25, 50.2],      
            [-33.12, -12.88, -46.0],    
            [0.945, 4.055, 5.0],     
            [123.4, 567.8, 691.2], 
            [0.007, 0.003, 0.01], 
            [-88.5, 88.5, 0.0],    
            [1.15, 1.15, 2.3],       
            [9.99, 0.01, 10.0],      
            [-10.75, -10.25, -21.0], 
            [50.6, 24.4, 75.0],    
            [0.55, 0.25, 0.8]
        ];

        add_cases.forEach(([a, b, expected]) => {
            expect(BasicOperation.add(a, b)).toBeCloseTo(expected, 3);
        });
    });

    test('test_subtract parameterized', () => {
        const subtract_cases = [
            [85.5, 30.2, 55.3],       
            [10.0, 15.5, -5.5],      
            [0.0, 7.25, -7.25],      
            [-10.8, -5.4, -5.4],    
            [-2.5, 3.5, -6.0],     
            [500.75, 125.25, 375.5], 
            [0.009, 0.004, 0.005], 
            [45.0, 12.0, 33.0],    
            [5.5, 2.75, 2.75],       
            [100.0, 0.01, 99.99],      
            [-50.0, -50.0, 0.0], 
            [88.6, 44.3, 44.3],    
            [1.25, 0.75, 0.5]
        ];

        subtract_cases.forEach(([a, b, expected]) => {
            expect(BasicOperation.subtract(a, b)).toBeCloseTo(expected, 3);
        });
    });
});
