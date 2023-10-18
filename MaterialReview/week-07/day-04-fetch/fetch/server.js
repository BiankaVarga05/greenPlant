'use strict';

const path = require('path');
const express = require('express');
const app = express();
// https://masteringjs.io/tutorials/express/express-json
// app.use() -> middleware -> When a request comes Express executes the functions you passed
// express.json() -> parses incoming JSON requests and puts the parsed data in req.body
app.use(express.json());
app.listen(3000);
app.use('/static', express.static(path.join(__dirname, 'public')));


let animals = [
  { id: 1, name: 'cat' },
  { id: 2, name: 'dog' },
  { id: 3, name: 'bird' },
  { id: 4, name: 'fox' },
]


app.get('/', function (req, res) {
  res.sendFile(path.join(__dirname, 'index.html'));
});

app.get('/fetch.js', function (req, res) {
  res.sendFile(path.join(__dirname, 'fetch.js'));
});

// GET returning all animals
app.get('/animals', (req, res) => {
  if (animals.length === 0) {
    res.status(501).json({ message: 'Have no animal present' })
  } else {
    console.log("Returned all animals");
    res.status(200).json({ "animals": animals });
  }
});

// GET returning one animal
app.get('/animals/:id', (req, res) => {
  let animalById = animals.find((animal) => animal.id === Number(req.params.id));

  if (!animalById) {
    res.status(404).json({ "error": "No animal with given id" });
  } else {
    console.log("Returned new animal: " + newAnimal);
    res.status(200).json({ "Requested:": animalById });
  }
})

// POST: creating an animal
app.post('/animal', (req, res) => {
  let newAnimal = req.body;
  animals.push(newAnimal);
  console.log("Added new animal: " + newAnimal);
  res.status(404).json({ "message": newAnimal});
})
