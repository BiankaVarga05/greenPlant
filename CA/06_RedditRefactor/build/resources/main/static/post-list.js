const postSection = document.getElementById("left");

fetch("/reddit/posts")
    .then(response => response.json())
    .then(data => {
        for (const post of data.posts) {
            postSection.appendChild(createPostDiv(post))
        }
    });

const rightSection = document.getElementById("right");
const createButton = document.createElement("a");
createButton.innerText = "Submit new post";
createButton.href = "/reddit/create";
rightSection.appendChild(createButton);

function createPostDiv(post) {
    const postDiv = document.createElement("post");
    postDiv.classList.add("post");
    postDiv.setAttribute("data-id", post.id);
    postDiv.setAttribute("data-title", post.title);
    postDiv.setAttribute("data-url", post.url);
    postDiv.setAttribute("data-score", post.score);
    postDiv.setAttribute("data-elapsed", getElapsed(post.timestamp, false))

    const postContent = document.createElement("div");
    postContent.classList.add("post-content");
    const title = document.createElement("h2");
    title.innerText = post.title;
    title.onclick = () => {window.open(post.url, "_blank");}
    postContent.appendChild(title);
    const elapsed = document.createElement("p");
    elapsed.innerText = getElapsed(post.timestamp, true);
    postContent.appendChild(elapsed);

    const buttons = document.createElement("post");
    buttons.id = "buttons";
    const edit = document.createElement("a");
    edit.innerText = "edit"
    edit.href = `/reddit/edit?postId=${post.id}&postTitle=${post.title}&postUrl=${post.url}`;
    buttons.appendChild(edit);
    const remove = document.createElement("a");
    remove.innerText = "remove"
    remove.href = "";
    remove.onclick = removePost(post.id, postDiv);
    buttons.appendChild(remove);
    postContent.appendChild(buttons);
    postDiv.appendChild(postContent);

    const voting = document.createElement("post");
    voting.classList.add("voting");
    const score = document.createElement("p");
    score.innerText = postDiv.dataset.score;
    const upvote = document.createElement("a");
    upvote.href = "";
    upvote.innerText = "⬆️";
    upvote.onclick = votePost(postDiv, "up", score);
    const downvote = document.createElement("a");
    downvote.href = "";
    downvote.innerText = "⬇️";
    downvote.onclick = votePost(postDiv, "down", score);
    voting.appendChild(upvote);
    voting.appendChild(score);
    voting.appendChild(downvote);
    postDiv.appendChild(voting);
    return postDiv;

}

function getElapsed(from, humanReadable) {
    let elapsed = Math.floor(Date.now() / 1000) - from;
    if (!humanReadable) {
        return elapsed;
    }

    if (elapsed < 5) {
        return "submitted just now";
    }

    let unit = "second";
    if (elapsed >= 60) {
        elapsed = Math.floor(elapsed / 60);
        unit = "minute";
        if (elapsed >= 60) {
            elapsed = Math.floor(elapsed / 60);
            unit = "hour"
            if (elapsed >= 24) {
                elapsed = Math.floor(elapsed / 24);
                unit = "day";
                if (elapsed >= 7) {
                    elapsed = Math.floor(elapsed / 7);
                    unit = "week";
                }
            }
        }
    }
    return `submitted ${elapsed} ${unit}${(elapsed === 1) ? "" : "s"} ago`;
}

function removePost(id, postDiv) {
    return (event) => {
        event.preventDefault();
        fetch("/reddit/posts/" + id, {method: "DELETE"})
            .then(response => {
                if (response.ok) {
                    postDiv.parentElement.removeChild(postDiv);
                } else {
                    alert("Uh-oh");
                }
            })};
}

function votePost(postElement, direction, scoreElement) {
    return (event) => {
        event.preventDefault();
        fetch("/reddit/posts/" + postElement.dataset.id + "/" + direction + "vote", {method: "PUT"})
            .then(response => {
                if (response.ok) {
                    let score = Number(scoreElement.innerText);
                    switch (direction) {
                        case "up":
                            score++;
                            break;
                        case "down":
                            score--;
                            break;
                    }
                    scoreElement.innerText = score;
                    postElement.setAttribute("data-score", score);
                } else {
                    console.log(response);
                }
            })
    }
}

function removeAllChildren(parentElement) {
    while (parentElement.firstChild) {
        parentElement.removeChild(parentElement.firstChild);
    }
}

let orderByBest = function (event) {
    event.preventDefault();
    const sorted = Array.from(postSection.children)
        .sort((a, b) => b.dataset.score - a.dataset.score);
    removeAllChildren(postSection);
    sorted.forEach(element => postSection.appendChild(element));
}

const bestFirst = document.getElementById("best-first");
bestFirst.href = "";
bestFirst.onclick = orderByBest;

let orderByNew = function (event) {
    event.preventDefault();
    const sorted = Array.from(postSection.children)
        .sort((a, b) => a.dataset.elapsed - b.dataset.elapsed);
    removeAllChildren(postSection);
    sorted.forEach(element => postSection.appendChild(element));
}

const newFirst = document.getElementById("new-first");
newFirst.href = "";
newFirst.onclick = orderByNew;