// Connect HTML to JS

// Write something when document loaded
console.log("Document loaded");

// Get the title
let title = document.getElementsByTagName("h1")[0];
let originalTitleText = title.textContent;


// Change the h1 title's content to "something funny" 
// when the mouse is over
let newTitle = "Kedd reggel nem tudunk szebb címet";

title.onmouseenter = function () {
    title.textContent = newTitle;
}

// Restore the original content when the mouse is not over
title.onmouseleave = function(){
    title.textContent = originalTitleText;
}


// Get all the P tags inside article-content
let articleContent = document.getElementsByClassName("article-content")[0];
let paragraphs = articleContent.getElementsByTagName("p");
let paragraphs2 = articleContent.querySelectorAll("p");
let paragraphs3 = articleContent.children;
let paragraphs4 = document.querySelectorAll(".article-content p");
console.log(paragraphs);
console.log(paragraphs2);
console.log(paragraphs3);
console.log(paragraphs4);

// Modify list of paragraphs: add a new one to the end
let newParagraph = document.createElement("p");
newParagraph.innerHTML = "Still tuesday morning";
articleContent.appendChild(newParagraph);
console.log("--------------");
console.log(paragraphs);
console.log(paragraphs2);

// Add this new P tag before the existing paragraphs
articleContent.insertBefore(newParagraph, paragraphs[1]);

// Remove this P tag
// newParagraph.remove();
// articleContent.removeChild(newParagraph);

// Add background colors to all the paragraphs inside article-content
for (const p of paragraphs) {
    //p.style = "background-color: red";
    //p.style.backgroundColor = "red";
    // p.setAttribute("style", "background-color: red");
    // p.className = "highlighted";
    // p.classList.add("highlighted");   // optimal
    // p.classList.add("red");

    // Add background color when the mouse is over (highlighted state)
    p.onmouseenter = function () {
        p.classList.add("highlighted");
        p.classList.add("red");
    }

    // Remove background colors to all these when the mouse is not over
    p.onmouseleave = function () {
        p.classList.remove("highlighted");
        p.classList.remove("red");
    }

    // Change the style to something else for the one that is clicked 
    // (representing selected state)
    // Remove the change for the second click
    p.onclick = function() {
        p.classList.toggle("selected");
    }
}

let testParagraph = document.getElementById("tester");
console.log(testParagraph.innerHTML);       // As in HTML code
console.log(testParagraph.textContent);     // Text content regardless of style
console.log(testParagraph.innerText);       // displayed content