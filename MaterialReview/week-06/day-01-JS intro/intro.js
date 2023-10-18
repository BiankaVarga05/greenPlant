"use strict";

// dynamic type
let a = 1;
a = 6;
console.log(a);
a = "acd";
console.log(a);

// weakly typed
console.log(2 + "2"); // "2" + "2" --> "22"

// strict mode
// y = 2;
// console.log(y);

// variables
let var1 = 10;
let var2 = 3.3;
let var3 = "ab'c fwef";
let var4 = 'ab"c';
let var5 = false;
var1 = 'a';

const myConts = 2;
// myConts = 6; // error

// const myConts2;
// // ..
// myConts2 = 4; // error
console.log(myConts);

// var/let
var w = 1;
w = 10;
var w = 7;

let t = 5;
//let t = 3; // error

// typeof
console.log(typeof var1);
let typeofVar1 = typeof var1;
console.log(typeofVar1);

// == vs ===
let n1 = 10;
let n2 = "10";
if (n1 == n2) {
    console.log("values equal");
}
if (n1 === n2) {
    console.log("values and types equal");
}

// undef/null
let age; // declaration
console.log(age);  // undefined
age = 10; // definition
let name = "Anna";
let middleName = null;

// arrays
let myArray = [1, 2, 3];
myArray[3] = 4;
myArray[100] = 101;
console.log(myArray[100]);
console.log(myArray[99]);  // undefined
console.log(myArray.length);
myArray[10] = 'a';
console.log(myArray)

// for i
const chars = ['a', 'b', 'c'];
for (let i = 0; i < 3; i++) {
    console.log(chars[i]);
}

// for of -> elem
for (let char of chars) {
    console.log(char);
}

// for in -> index
for (let index in chars) {
    console.log(chars[index]);
}

// let vs var
let j = 5;
for (let j = 0; j < 3; j++) {
    // ...
    console.log(j);
}
console.log(j); // 5 -> let block scoped

var k = 5;
for (var k = 0; k < 3; k++) {
    // ...
}
console.log(k); // 3 -> var global scoped

// objects
let person = {
    "name": "Béla",
    "age": 45,
    "1": 1,
    "let": 123
}
person.gender = "male";  // new property
console.log(person);

// accessing a property
console.log(person.age);
console.log(person["age"]);

let propName = "gender";
console.log(person[propName]);
console.log(person[1]);
person.middleName = null;

// delete prop
person["let"] = undefined;
console.log(person);

delete person["let"];
console.log(person);

for (let prop in person) {
    console.log(prop + ": " + person[prop]);
}

// functions
// named 
function sayHello(name, timeOfDay) {
    console.log("Hello " + name + "! It's a nice " + timeOfDay);
}
sayHello("Béla", "morning");
sayHello("Béla");
sayHello("Béla", "morning", "haha");

// function expression
const add = function (a, b) {
    return a + b;
}

const multiply = function (a, b) {
    return a * b;
}

function calculate(x, y, operation) {
    console.log(operation(x, y));
}
calculate(1, 2, add);
calculate(1, 2, multiply);

// arrow function
const sayHello2 = (name, timeOfDay) => {
    console.log("Hello " + name + "! It's a nice " + timeOfDay);
}
sayHello2('Anna', "evening");
