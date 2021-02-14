const { it, notEqual, equal } = require("../../../Test");

require("./PromiseAllModified");

it("Should return a promise even if there are failed promises.", async function () {
  const promise1 = Promise.resolve(3);
  const promise2 = 42;
  const promise3 = new Promise((resolve) => {
    setTimeout(resolve, 100, "foo");
  });
  const promise4 = new Promise((_, reject) => {
    setTimeout(reject, 100, "bar");
  });
  
  const results = await Promise.all([promise1, promise2, promise3, promise4]);

  equal(3, results[0]);
  equal(42, results[1]);
  equal("foo", results[2]);
  notEqual("bar", results[3]);
  equal(null, results[3]);
});
