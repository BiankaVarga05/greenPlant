const { readFileSync } = require('fs');
const { readFile } = require('fs/promises');

// Read file synchronously

function readFileSynchronously() {
  console.log(readFileSync('package.json', 'utf-8'));
}

readFileSynchronously();

// Read file with promise

function readFileWithPromise() {
  readFile('package.json', 'utf-8')
    .then((content) => {
      console.log(content);
    })
    .catch((error) => {
      console.log('ERROR!', error);
    })
}

readFileWithPromise();

// Read file with async/await

async function readFileWithAsyncAwait() {
  try {
    const content = await readFile('package.json', 'utf-8');
    console.log(content);
  } catch (error) {
    console.log('ERROR!', error);
  }
}

readFileWithAsyncAwait();
