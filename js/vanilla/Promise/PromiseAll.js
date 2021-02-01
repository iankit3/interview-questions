let p1 = new Promise((res, rej) => {
  setTimeout(() => {
    res("2000");
  }, 2000);
});

let p2 = Promise.resolve(100);
let p3 = Promise.resolve(1000); //fetch("https://www.google.com")

Promise.all([p1, p2, p3]).then((values) => {
  //console.log(values);
});

PromiseAll([p1, p2, p3])
  .then((values) => {
    console.log("MyPromise completed");
    console.log(values);
  })
  .catch((e) => console.log(` Error ${e}`));

function PromiseAll(promises) {
  return new Promise((resolve, reject) => {
    let results = new Array(promises.length),
      count = 0;

    promises.forEach((promise, index) => {
      Promise.resolve(promise).then((res) => {
        count++;
        results[index] = res;
        if (count == promises.length) {
          resolve(results);
        }
      }).catch(e => reject(e));
    });
  });
}
