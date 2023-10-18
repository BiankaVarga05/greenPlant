// Commands:
// Access element by id
let element = document.getElementById("id");
element = document.querySelector("#id");

// Access element by class
document.getElementsByClassName('class-name');
document.querySelectorAll(".class-name");

// Access element by tag:
document.getElementsByTagName("h2");
document.querySelectorAll("h2");

// Access element by CSS selector
document.querySelector('css-selector');
document.querySelectorAll('css-selector');

// -----------------------------------------------------------------------
// Create new element:
document.createElement("li");

// Append an element
element.appendChild(newElement);
element.insertBefore(newElement, existingElement);

// Move an element:
newParent.appendChild(existingElement);

// Remove an element:
element.remove();
parent.removeChild(child);

// Change text content of an element:
// Assign a string value to the `textContent/innerText/innerHTML` property.
element.textContent = "new text content";
// or append a textNode to the element 
element.appendChild(document.createTextNode("text"));

// Set an attribute
element.getAttribute("href");
element.setAttribute("class", "pie");
element.toggleAttribute()

// Modify element style
element.style.padding = "10px 0 0 0";                // Camel case
element.style.setProperty('padding-top', '10px');
element.setAttribute("style", "padding-top: 10px");

// Add new class to the element
element.className += 'new-class';
element.classList.add('new-class');