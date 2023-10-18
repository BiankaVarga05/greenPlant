let numbers = [-1, 1, 2, 3, 4, 5, 6, 7, 8];

// function filterLargerThanTwo(numbers) {
//     let result = [];

//     for (const number of numbers) {
//         if (number > 2) {
//             result.push(number);
//         }
//     }

//     return result;
// }

// function filterNonNegative(numbers) {
//     let result = [];

//     for (const number of numbers) {
//         if (number >= 0) {
//             result.push(number);
//         }
//     }

//     return result;
// }

// function filterEven(numbers) {
//     let result = [];

//     for (const number of numbers) {
//         if (number % 2 === 0) {
//             result.push(number);
//         }
//     }

//     return result;
// }


function filter (nums, filterCondition) {
    let result = [];

    for (const number of nums) {
        if (filterCondition(number)) {
            result.push(number);
        }
    }

    return result;
}

// We have three functions
// Make just one to avoid code duplication by using a callback function
// Use it three times to implement the behavior of these 3 functions

let condition = function (number) {
    return number % 2 === 0;
}

console.log(filter(numbers, condition));

console.log(filter(numbers, function(number) {
    return number >= 0;
}));

// filterLargerThanTwo
console.log(filter(numbers, (number) => {
    return number > 2;
}));


