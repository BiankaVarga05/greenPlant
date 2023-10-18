document.addEventListener('DOMContentLoaded', () => {
    const submitButton = document.getElementById("submit");
    const generalMessage = document.getElementById("general-message");
    const titleInput = document.getElementById("title");
    const genreInput = document.getElementById("genre");
    const ratingInput = document.getElementById("rating");
    const titleError = document.getElementById("title-error");
    const ratingError = document.getElementById("rating-error");
    const orderByRatingButton =  document.getElementById("by-rating");
    const orderByTitleButton = document.getElementById("by-title");
    const movieList = document.getElementById("movie-list");

    function handleError(){
        let isError = false;

        if(titleInput.value === ""){
            titleError.innerHTML = "Title is required!";
            isError = true;
        }
        if(ratingInput.value === ""){
            ratingError.innerHTML = "Rating is required!"
            isError = true;
        } else if(ratingInput.value < 1 || ratingInput.value > 5){
            ratingError.innerHTML = "Rating must be between 1-5!"
            isError = true;
        }

        return isError;
    }

    function clearMessages(){
        titleError.innerHTML = "";
        ratingError.innerHTML = "";
        generalMessage.innerHTML = "";
    }

    function getCurrentMovies(orderBy){
        // movieList.innerHTML = "";
        // fetch("/api/movies?order=" + orderBy)
        fetch(`/api/movies?order=${orderBy}`)
            .then(response => response.json())
            .then(data => {
                // error
                if(data.message){
                    console.log(data.message);
                }
                // success
                else {
                    movieList.innerHTML = "";
                    data.forEach(movie => {
                        let li = document.createElement("li"); // <li></li>
                        li.innerHTML = `<strong>${movie.title}</strong> (${movie.genre}) - ${movie.rating}`;
                        movieList.appendChild(li);
                    })
                }
            })
            .catch(error => console.error(error));
    }

    getCurrentMovies("title");

    submitButton.onclick = (event) => {
        event.preventDefault();

        // clear messages
        clearMessages()

        // validation
        if(handleError()){
            return;
        }

        const inputData = {
            title: titleInput.value,
            genre: genreInput.value,
            rating: ratingInput.value
        }

        // fetch
        fetch("/api/movies", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(inputData)
        })
        // response
            .then(response => response.json())
            .then(data => {
                // error scenario
                if(data.message){
                    generalMessage.innerHTML = data.message;
                    generalMessage.style.color = "red";
                }
                // success sceanrio
                else {
                    generalMessage.innerHTML = "Successfully added!";
                    generalMessage.style.color = "green";
                    titleInput.value = "";
                    genreInput.value = "";
                    ratingInput.value = "";
                    getCurrentMovies("title");
                }
            })
            .catch(error => {
                console.error(error);
            })
    }

    orderByTitleButton.onclick = (event) => {
        event.preventDefault();
        clearMessages();

        // fetch -> order=title
        getCurrentMovies("title");
    }


    orderByRatingButton.onclick = (event) => {
        event.preventDefault();
        clearMessages();

        // fetch -> order=rating
        getCurrentMovies("rating");
    }
})