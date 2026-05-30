const BasicOperation = require('./basicOperation');

test('add two numbers', () => {
    const expected = 5.0;
    const result = BasicOperation.add(2.0, 3.0);

    expect(result).toBe(expected);
});

test('subtract two numbers', () => {
    const expected = 3.0;
    const result = BasicOperation.subtract(5.0, 2.0);

    expect(result).toBe(expected);
});