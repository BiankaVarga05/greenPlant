document.addEventListener('DOMContentLoaded', () => {
    const submitButton = document.querySelector('#submit-btn');
    const messageDiv = document.querySelector("#message");


    submitButton.onclick = (event) => {
        event.preventDefault();

        // get the values from the form
        let name = document.querySelector('#name-input').value;
        let email = document.querySelector('#email-input').value;
        let phoneNumber = document.querySelector('#phone-input').value;
        let password = document.querySelector('#password-input').value;
        let female = document.querySelector('#female');
        let male = document.querySelector('#male');

        // validate the values 
        const errors = [];
        const errorBox = document.querySelector("#errors");
        errorBox.innerHTML = "";

        if(name.length < 3){
            errors.push("Name is missing or too short!");
        } else if(name.length > 10){
            errors.push("Name is too long! (max 10 characters)");
        }

        if(!email.includes('@')){
            errors.push(("Email must contain a @!"));
        }

        if(password.length < 8){
            errors.push("Password is too short!");
        }

        // with regexp
        if(!phoneNumber.match(/^[+0][0-9\s-]{8,}$/)){
            errors.push("Phone number is not valid");
        }

        // display errors if needed and return from the function
        if(errors.length > 0){
            errors.forEach((error) => {
                errorBox.innerHTML += `<div>${error}</div>`;
            });
            return;
        }

        // create the object from the correct incoming data
        const newAccount = {
            name,  // name: name
            email,
            phoneNumber,
            gender: female.checked ? female.value : male.value,
            password
        }

        // send the request to teh backend
        fetch('/sign-up', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newAccount)
        })
            // handle the response from the bakcend and generate a message on the frontend
            .then(response => response.json())
            .then(data => {
                messageDiv.innerHTML = data.name + ", thank you for creating your account!";
            })
    }
});