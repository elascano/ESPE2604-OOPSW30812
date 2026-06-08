const BasicOperation = require('../controller/basicOperation');

describe('BasicOperation - Unit Tests', () => {
   
    const addCases = [
        [1.2, 2.4, 3.6],
        [5.0, 5.0, 10.0],
        [1.1, 1.1, 2.2],
        [-1.5, -2.5, -4.0]
    ];


    const subtractCases = [
        [3.6, 1.2, 2.4],
        [10.0, 5.0, 5.0],
        [2.2, 1.1, 1.1],
        [-4.0, -1.5, -2.5]
    ];


    test.each(addCases)(
        'should correctly add %p and %p to get %p', 
        (operand1, operand2, expectedResult) => {
            const actualResult = BasicOperation.add(operand1, operand2);
            expect(actualResult).toBeCloseTo(expectedResult);
        }
    );

    test.each(subtractCases)(
        'should correctly subtract %p minus %p to get %p', 
        (minuend, subtrahend, expectedResult) => {
            const actualResult = BasicOperation.subtract(minuend, subtrahend);
            expect(actualResult).toBeCloseTo(expectedResult);
        }
    );

});