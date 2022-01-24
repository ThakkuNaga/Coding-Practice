
let year = 100;
function century(year) {
    let post =
      Math.ceil(year / 100) <= 20
        ? "th"
        : Math.ceil(year / 100) % 10 === 1
        ? "st"
        : Math.ceil(year / 100) % 10 === 2
        ? "nd"
        : Math.ceil(year / 100) % 10 === 3
        ? "rd"
        : "th";
    return `${Math.ceil(year / 100)}${post} century`;
}
console.log(century(1756));