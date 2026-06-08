const BasicOperation = require('./espe.edu.ec.calculator.controller/BasicOperation');

describe('BasicOperation - Parameterized Add Tests', () => {

    const addCases = [
        [1.2, 2.4, 3.6],       
        [5.0, 5.0, 10.0],      
        [0.0, 0.0, 0.0],       
        [-1.5, -2.5, -4.0],    
        [-5.0, 3.0, -2.0],    
        [100.5, 200.5, 301.0],
        [0.001, 0.002, 0.003],
        [10.0, 20.0, 30.0],   
        [1.1, 1.1, 2.2],      
        [9.9, 0.1, 10.0],     
        [-10.0, -10.0, -20.0],
        [50.0, 25.0, 75.0],   
        [0.5, 0.25, 0.75]     
    ];

    test.each(addCases)('should add %p + %p to equal approximately %p', (addend1, addend2, expected) => {
        console.log(`Running parameterized add test for: ${addend1} + ${addend2}`);
        
        expect(BasicOperation.add(addend1, addend2)).toBeCloseTo(expected, 3);
    });
});

describe('BasicOperation - Parameterized Subtract Tests', () => {
    
    const subtractCases = [
        [3.6, 1.2, 2.4],       
        [10.0, 5.0, 5.0],      
        [0.0, 0.0, 0.0],       
        [-4.0, -1.5, -2.5],    
        [-2.0, 3.0, -5.0],     
        [301.0, 100.5, 200.5], 
        [0.003, 0.001, 0.002], 
        [30.0, 10.0, 20.0],    
        [2.2, 1.1, 1.1],       
        [10.0, 0.1, 9.9],      
        [-20.0, -10.0, -10.0], 
        [75.0, 25.0, 50.0],    
        [0.75, 0.25, 0.5]      
    ];

    test.each(subtractCases)('should subtract %p - %p to equal approximately %p', (minuend, subtrahend, expected) => {
        console.log(`Running parameterized subtract test for: ${minuend} - ${subtrahend}`);
        expect(BasicOperation.subtract(minuend, subtrahend)).toBeCloseTo(expected, 3);
    });
});

