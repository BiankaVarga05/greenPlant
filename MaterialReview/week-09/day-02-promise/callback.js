// Callback

function greetFormally(name) {
  return 'Good morning ' + name;
}

function greetInformally(name) {
  return 'Hawdy ' + name;
}

function greet(name, callback) {
  return callback(name);
}

console.log(greet('Joe', greetInformally));
console.log(greet('Joe', greetFormally));

// Callback with function expression

console.log(greet('Joe', function(name) {
  return 'Hi ' + name;
}));

// Callback with arrow function

console.log(greet('Joe', (name) => {
  return 'Hi ' + name;
}));