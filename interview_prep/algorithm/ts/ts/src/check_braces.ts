export function check(braces: string) {
    let opening = ['(', '[', '{']
    let closing = [')', ']', '}']
    let arr = []
    for (let i = 0; i < braces.length; i++) {
        if (opening.includes(braces[i])) {
            arr.push(braces[i])
        } else if (closing.indexOf(braces[i]) === opening.indexOf(arr[arr.length - 1])) {
                arr.pop()
        } else return false
    } return arr.length === 0;
}