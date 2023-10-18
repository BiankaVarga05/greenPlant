'use strict';

// We have a greeter function
// Use it as a callback function to say Hi to Riel 3 times

let mentorName = "Riel";

function greeter(name, times) {
  let message = "";
  for (let i = 0; i < times; i++) {
    message += `Hi ${name}!` + "\n";
  }
  return message;
}

function otherFunction(greating){
  console.log(greating(mentorName, 3));
}

otherFunction(greeter);