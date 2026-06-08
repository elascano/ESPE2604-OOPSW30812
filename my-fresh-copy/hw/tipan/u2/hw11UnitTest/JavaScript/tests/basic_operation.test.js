const BasicOperation = require('../controller/basic_operation');

describe('TestBasicOperation', () => {

    test('test_add', () => {

        console.log("add");

        const result = BasicOperation.add(1.2, 2.4);

        expect(result).toBeCloseTo(3.6, 3);
    });

    test('test_subtract', () => {

        console.log("subtract");

        const result = BasicOperation.subtract(5.0, 3.0);

        expect(result).toBeCloseTo(2.0, 3);
    });
});