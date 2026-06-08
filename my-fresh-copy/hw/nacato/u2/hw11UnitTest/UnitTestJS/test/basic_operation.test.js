const BasicOperation = require('../controller/basic_operation');

describe('TestBasicOperation', () => {
    
    test('test_add', () => {
        const add_cases = [
            [1.5, 2.5, 4.0],
            [10.0, 5.0, 15.0],
            [0.0, 0.0, 0.0],
            [2.5, 3.5, 6.0],
            [4.0, 4.0, 8.0],
            [150.2, 250.3, 400.5],
            [20.0, 30.0, 50.0],
            [1.2, 1.2, 2.4],
            [8.5, 1.5, 10.0],
            [0.4, 0.20, 0.60]
        ];

        console.log("test_add (test_basic_operation.TestBasicOperation.test_add) ... Running parameterized add test for: 1.2 + 2.4");
        
        add_cases.forEach(([addend1, addend2, expResult]) => {
            console.log(`Running parameterized add test for: ${addend1} + ${addend2}`);
            const result = BasicOperation.add(addend1, addend2);
            expect(result).toBeCloseTo(expResult, 3);
        });
        
        console.log("\x1b[32mck\x1b[0m");
    });

    test('test_subtract', () => {
        const sub_cases = [
            [20.0, 10.0, 10.0],
            [0.0, 0.0, 0.0],
            [-5.5, -2.5, -3.0],
            [-1.0, 4.0, -5.0],
            [400.5, 200.5, 200.0],
            [50.0, 20.0, 30.0],
            [3.3, 1.1, 2.2],
            [15.0, 5.0, 10.0],
            [90.0, 40.0, 50.0],
            [0.85, 0.35, 0.50]
        ];

        console.log("test_subtract (test_basic_operation.TestBasicOperation.test_subtract) ... Running parameterized subtract test for: 3.6 - 1.2");
        
        sub_cases.forEach(([minuend, subtrahend, expResult]) => {
            console.log(`Running parameterized subtract test for: ${minuend} - ${subtrahend}`);
            const result = BasicOperation.subtract(minuend, subtrahend);
            expect(result).toBeCloseTo(expResult, 3);
        });
        
        console.log("\x1b[32mck\x1b[0m");
    });
});