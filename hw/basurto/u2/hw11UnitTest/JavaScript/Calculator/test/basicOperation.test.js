const BasicOperation = require('../controller/basicOperation');

describe('BasicOperation Tests', () => {

    test('test add', () => {

        console.log("add");

        let addend1 = 2.4;
        let addend2 = 1.2;

        let expectedResult = 3.6;

        let result = BasicOperation.add(addend1, addend2);

        expect(result).toBeCloseTo(expectedResult);

    });

    test('test subtract', () => {

        console.log("subtract");

        let minuend = 3.6;
        let subtrahend = 1.2;

        let expectedResult = 2.4;

        let result = BasicOperation.subtract(minuend, subtrahend);

        expect(result).toBeCloseTo(expectedResult);

    });

});