function flatten(arr){
    return arr.map(a => {
        if(Array.isArray(a)){
            return flatten(a)
        }  

        return a;
    }).join(",").split(",")
}
let arr = [10, 02, 01, [10, [20, [30, [1]], [11]]]]


//console.log(flatten(arr));

function flattenUsingConcat(arr){
    return [...arr]
}
console.log(flattenUsingConcat(arr))