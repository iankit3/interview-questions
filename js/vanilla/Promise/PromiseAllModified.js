/**
 * Promise.all returns a promise and this returned promise will resolve
 * when all of the input's promises have resolved.
 *
 * Task is to modify it in such a way, that
 * if any one the promises succeed, then
 * return the successful promise along with the
 * failed promises set as null.
 * 
 * Asked at Walmart labs.
 */

Promise.all = async function (promises) {
  const results = [];

  for (promise of promises) {
    try {
      results.push(await promise);
    } catch (err) {
      results.push(null);
    }
  }

  return results;
};
