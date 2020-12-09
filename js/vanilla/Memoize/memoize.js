/**
 * Implements a function cache
 * @function memoize
 * @param {function} fn
 * @returns {function}
 */

 function memoize(fn){
    let cache = {};

    return function(...args){
        let key = JSON.stringify(args);
        if(key in cache){
            console.log("cache hit");
            return cache[key]
        }

        return cache[key] = fn.apply(this, args);
    }
 }

 let times100 = (num) => num * 100;
 let memoizedTimes100 = memoize(times100);

 console.log(memoizedTimes100(30));
 console.log(memoizedTimes100(3));
 console.log(memoizedTimes100(12));
 console.log(memoizedTimes100(30));


