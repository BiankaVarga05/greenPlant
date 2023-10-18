document.getElementById("submit").onclick = () => {
    const post = {
        title: document.getElementById("title").value,
        url: document.getElementById("url").value
    }

    let data = JSON.stringify(post);

    fetch("/reddit/posts", {
        method: "POST",
        body: JSON.stringify(post),
        headers: {"Content-Type": "application/json"},
    })
        .then(response => {
            if (response.ok) {
                window.location = "/reddit/";
            } else {
                alert("Uh-oh");
            }
        });
}