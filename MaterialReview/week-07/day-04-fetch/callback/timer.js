'use strict';
// We have the two buttons and the paragraph stored in a variable.
let button1 = document.getElementsByTagName("button")[0];
let button2 = document.getElementsByTagName("button")[1];
let paragraph = document.getElementsByTagName("p")[0];

let duma = "duma at 8";
console.log('page loaded' + duma);

// Use this function to update the paragraph
function updateText(text) {
  paragraph.innerText = text;
}

// Tasks:
// Display a text at page load: "Initial text at load"
setTimeout(() => updateText("Initial text at load" + duma), 0);


// Display a text after 2 seconds: "2 seconds after load"
setTimeout(() =>  updateText("2 seconds after load" + duma), 2000);

// Display a text after 7 seconds: "7 seconds after load"
setTimeout(() =>  updateText("7 seconds after load" + duma), 7000);

// When the first button is clicked, display "Button pressed" 
// and then log a counter starting from 0 
// and increased by one at every second on the console

let id;
button1.onclick = () => {
  console.log(duma);
  console.log("Button pressed" + duma);
  let counter = 0;
  id = setInterval(() => {
    console.log(counter++);
  }, 1000);
};

// Stop counting by pressing the second button
button2.onclick = () => {
  console.log("Second button clicked");
  clearInterval(id);
};

duma = "duma at 42";
console.log(duma);