const params = new URL(window.location.href).searchParams;
const id = params.get("postId");
let title = params.get("postTitle");
let url = params.get("postUrl");

const titleArea = document.getElementById("title");
const urlArea = document.getElementById("url");

titleArea.innerText = title;
urlArea.innerText = url;

document.getElementById("submit").onclick = () => {
    const post = {
        title: titleArea.value,
        url: urlArea.value
    }

    fetch("/reddit/posts/" + id, {
        method: "PUT",
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