// Island Problem
// Twilio
// A variation of it - `Rotten Apple` was asked in RSA Securities
// This problem is classified as `Multi-source BFS problem`
//     - ex - https://leetcode.com/problems/map-of-highest-peak/

var arr = [
    [0, 1, 0, 1],
    [1, 0, 0, 1],
    [1, 1, 0, 1],
    [1, 0, 0, 1],
   ];

var move = (x, y, arr, count, visited) => {
  //console.log(count)
  const dirs = [
    [-1, 0],
    [-1, 1],
    [0, 1],
    [1, 1],
    [1, 0],
    [1, -1],
    [0, -1],
    [-1, -1],
  ];

  for (let d of dirs) {
    const x1 = x + d[0],
      y1 = y + d[1];

    // check out of bound
    if (x1 < 0 || y1 > arr.length - 1) return;
    // check visited
    if (visited.indexOf(x1 + "," + y1) >= 0) return;

    if (arr[x1][y1] === 1) {
      count.count++;
      visited.push(x1 + "," + y1);
      move(x1, y1, arr, count, visited);
    }
  }
};

var findClusterOf1 = (arr) => {
  const n = arr.length;
  let COUNT = 0;

  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < n; ++j) {
      const p = arr[i][j];

      if (p === 1) {
        let a = [];
        a.push(i + "," + j);
        let count = { count: 1 };

        move(i, j, arr, count, a);
        COUNT = Math.max(COUNT, count.count);
      }
    }
  }

  return COUNT;
};

console.log(findClusterOf1(arr));
