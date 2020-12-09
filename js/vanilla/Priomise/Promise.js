// https://exploringjs.com/es6/ch_promises.html#sec_demo-promise
// Github code of the above
// https://github.com/rauschma/demo_promise/blob/master/demo_promise1_single.js

/**
 * Features:
     then() must work independently if the promise is
     settled either before or after it is called
     You can only resolve or reject once
 * 
 */

function MyPromise() {
  this.value = null;
  this.state = "pending";
  this.resolveCbs = [];
  this.rejectCbs = [];
}

MyPromise.prototype.then = function (resolveCb, rejectCb) {
  if (this.state == "pending") {
    this.resolveCbs.push(resolveCb);
    if (rejectCb) {
      this.rejectCbs.push(rejectCb);
    }
  } else if (this.state == "fulfilled") {
    resolveCb(this.value);
  } else if (this.state == "rejected") {
    rejectCb(this.value);
  }
};

MyPromise.prototype.resolve = function (value) {
  this.state = "fulfilled";
  this.resolveCbs.forEach((cb) => cb(value));
};

MyPromise.prototype.reject = function (value) {
  this.state = "rejected";
  this.rejectCbs.forEach((cb) => cb(value));
};



// Use
var mp = new MyPromise();
//console.log(mp)
setTimeout(() => {
  //mp.resolve(100);
  mp.reject(-1);
}, 1000);

mp.then(
  (val) => {
    console.log(val);
  },
  (val) => {
    console.error(val);
  }
);
