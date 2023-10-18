'use strict';

let button = document.getElementsByTagName("button")[0];
let paragraph = document.getElementsByTagName("p")[0];

// Modify the inner text of the paragraph when the first button is pressed from
// - a function stored in a variable (Function expression): "Text set by stored function"

let functionExpression = function () {
    paragraph.innerText = "Text set by stored function";
}

// button.onclick = functionExpression;


// - an anonymus function: "Text set by anonymus function"
// button.onclick = function () {
//     console.log("Anonymus");
//     paragraph.innerText = "Text set by anonymus function";
// }



// - a lambda / arrow function: "Text set by lambda function"
// button.onclick = () => {
//     console.log("Arrow");
//     paragraph.innerText = "Text set by lambda function";   
// }

button.addEventListener("click", () => {
    console.log("arrow");
});

button.addEventListener("click", function () {
    console.log("anonymus");
});