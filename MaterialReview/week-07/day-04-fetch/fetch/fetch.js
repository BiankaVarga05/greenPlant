'use strict';

// Get a message from Chuck Norris and display in chuck using 'https://api.chucknorris.io/'
// Test endpoints using Postman
const htmlBody = document.querySelector('body');
let chuck = document.getElementById("chuck");
let addButton = document.getElementById("add");
let listButton = document.getElementById("list");
let newId = document.getElementById("id");
let newName = document.getElementById("name");
let paragraph = document.getElementsByTagName("p")[0];
let ul = document.getElementsByTagName("ul")[0];


fetch('https://api.chucknorris.io/jokes/random')
  .then(response => response.json())
  .then(data => {
    chuck.innerText = data.value;
  });


// When "List animals" button pressed get the elements from the 
// backend and display as a list

listButton.onclick = function () {
  ul.innerHTML = "";
  console.log("Cars endpoint called")
  fetch("/cars")
    .then(response => response.json())
    .then(data => {
      data.cars.forEach(car => {
        let li = document.createElement("li");
        li.appendChild(document.createTextNode(car.id + " " + animal.brand));
        ul.appendChild(li);
      });
    });
}


addButton.onclick = function () {
  let animal = { id: newId.value, name: newName.value };
  fetch('/animal', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(animal),
  })
    .then(
      response => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Jajjjjjjjj");
        }
      })
    .then(data => {
      console.log('Successfully added:', data.message.name);
    })
    .catch(error => {
      console.error('Error:', error);
    });
}







// When "Add animal" button pressed, add an animal to the server
// with the input contents
