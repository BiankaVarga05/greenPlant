

document.addEventListener('DOMContentLoaded', () => {
    const submitButton = document.getElementById("submit-btn");
    const messageDiv = document.getElementById("message");

    submitButton.onclick = (event) => {
        event.preventDefault();

        const urlInput = document.getElementById("url");
        const aliasInput = document.getElementById("alias");

        const newAlias = {
            url: urlInput.value,
            alias: aliasInput.value
        }

        fetch('/api/links', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newAlias)
        })
            .then(response => {
                if(response.ok){
                    return response.json();
                }
                throw new Error();
            })
            .then(data => {
                urlInput.value = "";
                aliasInput.value = "";
                messageDiv.style.color = "black";
                messageDiv.innerHTML =
                    "Your URL is aliased to <strong>"
                    + data.alias
                    + "</strong> and your secret code is <strong>"
                    + data.secretCode
                    + "</strong>.";
            })
            .catch(error => {
                messageDiv.style.color = "red";
                messageDiv.innerHTML = "Your alias is already in use!";
            })
    }
})