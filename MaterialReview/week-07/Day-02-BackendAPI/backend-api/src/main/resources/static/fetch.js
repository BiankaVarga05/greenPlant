'use strict';

let chuck = document.getElementById("chuck");
let addButton = document.getElementById("add");
let listButton = document.getElementById("list");
let id = document.getElementById("id");
let brand = document.getElementById("brand");
let year = document.getElementById("year");
let mark = document.getElementById("mark");
let ul = document.getElementsByTagName("ul")[0];


// Get a message from Chuck Norris and display in chuck using 'https://api.chucknorris.io/'
// https://api.chucknorris.io/jokes/random
fetch("https://api.chucknorris.io/jokes/random") // Also try http://444.hu/feed
  .then(response => {
    return response.json();
  })
  .then(chuckResponseObject => {
    chuck.innerText = chuckResponseObject.value;
  });


// When "List cars" button pressed get the elements from the
// backend and display as a list
listButton.onclick = () => {
  fetch("/car")
    .then(response => {
      return response.json();
    })
    .then(cars => {
      ul.innerHTML="";
      for (const car of cars) {
        let listItem = document.createElement("li");
        listItem.innerText = car.id + " - " + car.brand + " - " + car.year;
        ul.appendChild(listItem);
      }
    });
};

// When the Add car button pressed, create a new car based on input data
// and add the returned car to the list
addButton.onclick = () => {
  let newCar = {
    "id" : id.value,
    "brand" : brand.value,
    "year" : year.value,
    "registrationMark" : mark.value
  }

  fetch('/car', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(newCar),
  })
    .then(response => {
      if (response.status === 201) {
        return response.json();
      } else {
        throw new Error("Jajjjjjjjj");
      }})
    .then(car => {
      let listItem = document.createElement("li");
      listItem.innerText = car.id + " - " + car.brand + " - " + car.year;
      ul.appendChild(listItem);
      // console.log('Success:', car);
    })
    .catch(error => {
      console.error('Error:', error.message);
    });
}
