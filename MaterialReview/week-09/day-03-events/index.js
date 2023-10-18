// Topics to remember:
// - event loop
// - event bubbling
// - event.target (vs. event.currentTarget)
// - addEventListener (vs. on<event>)
// - click, keypress, focus, blur, mouseenter, mouseleave, scroll, input, change
// https://developer.mozilla.org/en-US/docs/Web/Events
// - load vs. DOMContentLoaded / readyStates
// - monitorEvents(element)
// https://blittle.github.io/chrome-dev-tools/console/monitor-events.html7

document.addEventListener("readystatechange", () => {
    console.log(document.readyState);
});

document.addEventListener('DOMContentLoaded', () => {

    const button = document.getElementById('button');
    const content = document.getElementById("content");
    const container = document.getElementById("container");

    content.addEventListener('click', (event) => {
        console.log(event.target);
        console.log(event.currentTarget);
    });


    // Limit execution of an event handler:
    let timeout = null;

    document.addEventListener('scroll', event => {
      if(timeout != null) {
        return;
      } 

      timeout = setTimeout(() => {
        console.log("scrolled");   // Do work
        timeout = null;
      }, 1500);
    });
});