const BasicOperation = require('./BasicOperation');

const addCases = [
    [1.2, 2.4, 3.6],
    [5.0, 5.0, 10.0],
    [0.1, 1.0, 1.1],
    [-1.5, -2.5, -4.0],
    [-5.0, 3.0, -2.0],
    [100.5, 200.5, 301.0],
    [0.001, 0.002, 0.003],
    [10.0, 20.0, 30.0],
    [1.1, 1.1, 2.2],
    [9.9, 0.1, 10.0]
];
addCases.forEach(([addend1, addend2, expected]) => {

    let result = BasicOperation.add(addend1, addend2);

    console.log(`${addend1} + ${addend2} = ${result}`);

    if (Math.abs(result - expected) < 0.01) {
        console.log("PASS\n");
    } else {
        console.log("FAIL\n");
    }
});


const subtractCases = [
    [3.6, 1.2, 2.4],
    [10.0, 5.0, 5.0],
    [0.8, 0.13, 0.67],
    [-4.0, -1.5, -2.5],
    [-2.0, 3.0, -5.0],
    [301.0, 100.5, 200.5],
    [0.003, 0.001, 0.002],
    [30.0, 10.0, 20.0],
    [2.2, 1.1, 1.1],
    [10.0, 0.1, 9.9]
];
subtractCases.forEach(([minuend, subtrahend, expected]) => {
    let result = BasicOperation.subtract(minuend, subtrahend);
    console.log(`${minuend} - ${subtrahend} = ${result}`);
    if (Math.abs(result - expected) < 0.01) {
        console.log("PASS\n");
    } else {
        console.log("FAIL\n");
    }
});