const BasicOperation = require('../src/calculator/controller/basic_operation');

describe('BasicOperation Tests', () => {

    test('testAdd', () => {
        console.log("add");
        const addend1 = 1.2;
        const addend2 = 2.4;
        const expResult = 3.6;
        
        const result = BasicOperation.add(addend1, addend2);
        
        expect(result).toBeCloseTo(expResult, 5);
    });

    test('testSubtract', () => {
        console.log("subtract");
        const minuend = 3.6;
        const subtrahend = 1.2;
        const expResult = 2.4; 
        
        const result = BasicOperation.subtract(minuend, subtrahend);
        
        expect(result).toBeCloseTo(expResult, 5);
    });
});