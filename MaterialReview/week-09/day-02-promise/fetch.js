// Fetch

function fetchExampleJSON() {
  const promise1 = fetch('https://api.chucknorris.io/jokes/random');

  const promise2 = promise1.then((response) => {
    console.log('Promise 1 fulfilled');

    if (response.ok) {
      const newPromise = response.json();
      return newPromise;
    }

    throw new Error(response.statusText);
  });

  const promise3 = promise2.then((data) => {
    console.log('Promise 2 fulfilled');
    return data;
  });

  const promise4 = promise3.then((data) => {
    console.log('Promise 3 fulfilled');
    console.log(data);
  });

  promise4.catch((error) => {
    console.log('ERROR!', error);
  })
}

fetchExampleJSON();

// Fetch with chaining

function fetchExampleJSONWithChaining() {
  fetch('https://api.chucknorris.io/jokes/random')
    .then((response) => {
      console.log('Promise 1 fulfilled');

      if (response.ok) {
        const newPromise = response.json();
        return newPromise;
      }

      throw new Error(response.statusText);
    })
    .then((data) => {
      console.log('Promise 2 fulfilled');
      return data;
    })
    .then((data) => {
      console.log('Promise 3 fulfilled');
      console.log(data);
    })
    .catch((error) => {
      console.log('ERROR!', error);
    });
}

// Fetch with async/await

async function fetchExampleJSONWithAsyncAwait() {
  try {
    const response = await fetch('https://api.chucknorris.io/jokes/random');

    if (!response.ok) {
      throw new Error(response.statusText);
    }

    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.log('ERROR!', error);
  }
}

const promise = fetchExampleJSONWithAsyncAwait();

// Fetch multiple resources

async function getJoke() {
  try {
    const response = await fetch('https://api.chucknorris.io/jokes/random');

    if (!response.ok) {
      throw new Error(response.statusText);
    }

    const data = await response.json();
    return data;
  } catch (error) {
    console.log('ERROR!', error);
  }
}

async function get3jokes() {
  const jokes = [
    await getJoke(),
    await getJoke(),
    await getJoke(),
  ];
  console.log(jokes);
}

get3jokes();

async function get3jokesConcurrently() {
  const jokes = await Promise.all([
    getJoke(),
    getJoke(),
    getJoke(),
  ]);
  console.log(jokes);
}

get3jokesConcurrently();
