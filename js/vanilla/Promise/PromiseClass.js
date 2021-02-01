/**
 * Uses - Revealing constructor pattern - https://blog.domenic.me/the-revealing-constructor-pattern/
 * Ref - https://exploringjs.com/es6/ch_promises.html#sec_demo-promise
 *       https://levelup.gitconnected.com/learn-javascript-promises-by-building-a-fully-working-promise-from-scratch-c9eabe73fa3
 */

// TODO: Looks complete but people have diff opinions on returning `this` from `then function`
class Promise {
  constructor(executor) {
    this.value = null;
    this.state = "pending";
    this.callbacks = [];
    this.resolve = this._resolve.bind(this);
    this.reject = this._reject.bind(this);

    executor(this.resolve, this.reject);
  }

  then = function (cb) {
    switch (this.state) {
      case "pending": {
        this.callbacks.push(cb);
        break;
      }
      case "fulfilled": {
        cb(this.value);
        break;
      }
    }

    return this;
  };

  _resolve = function (value) {
    this.state = "resolved";
    this.value = value;
    this.callbacks.forEach((cb) => cb(value));
  };

  _reject = function (value) {
    this.state = "rejected";
    this.value = value;
    this.callbacks.forEach((cb) => cb(value));
  };
}

let p = new Promise((res, rej) => {
  setTimeout(() => {
    res(100);
    //rej(new Error(100));
  }, 3000);
});

p.then((value) => {
  console.log(`Resolved with ${value}`);
}).then((value) => {
  console.log(`printed ${value}`);
});
