var res = [];
function objectHierarchyFlattener(key, val, paths) {
  var paths = [...paths, key];
  if (typeof val != "object") {
    var out = {
      [paths.join("_")]: val,
    };
    res.push(out);
    return out;
  }

  return Object.keys(val).map((k) => {
    return objectHierarchyFlattener(k, val[k], paths);
  });
}
var user = {
  name: "Some",
  address: {
    street: {
      main: "1st",
      cross: "10th",
    },
  },
};
objectHierarchyFlattener("user", user, []);
console.log(res);
