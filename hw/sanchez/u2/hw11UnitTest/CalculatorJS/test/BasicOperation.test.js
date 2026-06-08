const BasicOperation = require('../controller/BasicOperation');

describe('BasicOperation Tests', () => {
    
    test('add', () => {
        console.log("add");
        const addent1 = 1.2;
        const addent2 = 2.4;
        const expResult = 3.6;
        const result = BasicOperation.add(addent1, addent2);
        expect(result).toBeCloseTo(expResult, 5);
    });

    test('addsmall', () => {
        console.log("add");
        const addent1 = 4.2;
        const addent2 = 2.4;
        const expResult = 3.6;
        const result = BasicOperation.add(addent1, addent2);
        expect(result).toBeCloseTo(expResult, 3);
    });

    test('subtract', () => {
        console.log("subtract");
        const minuend = 0.0;
        const subtrahend = 0.0;
        const expResult = 0.0;
        const result = BasicOperation.subtract(minuend, subtrahend);
        expect(result).toBeCloseTo(expResult, 5);
    });
});