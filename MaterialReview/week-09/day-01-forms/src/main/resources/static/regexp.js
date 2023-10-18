// "Hello" or "hello"
const regEx1 = /[Hh]ello/;

//"HelloWorld"  or "Hello       World"
const regEx2 = /Hello\s*World/;

console.log("Hello   World".match(regEx2));