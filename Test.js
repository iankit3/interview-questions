const assert = require("assert");
module.exports = {
  it: async function (testCase, fn) {
    try {
      await fn();
      console.log(`✅\x1b[1;32m Passed. \x1b[0m${testCase}`);
    } catch (err) {
      console.log(`❌\x1b[1;31m Failed. \x1b[0m${testCase}`);
      console.log(err.message);
    }
  },

  equal: function (param1, param2) {
    assert.strictEqual(param1, param2, `Expected ${param1}, got ${param2}.`);
  },

  notEqual: function (param1, param2) {
    assert.notStrictEqual(param1, param2, `Not expecting ${param1}, but got ${param2}.`);
  },
};
