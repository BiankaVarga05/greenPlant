function add(a, b) {
    return a + b;
}

function subtract(a, b) {
    return a - b;
}

function multiply(a, b) {
    return a * b;
}

function divide(a, b) {
    return a / b;
}

// Write a function that can receive an operation and two numbers 
// and returns the result of the operation on those numbers
function calculate(numberA, numberB, operation){
    return operation(numberA, numberB);
}

console.log(calculate(2, 5, multiply));
console.log(calculate(6, 8, add));