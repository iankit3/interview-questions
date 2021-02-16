const { it, notEqual, equal } = require("../../../../Test");

require("./Date");

it("Should have getTomorrow method.", function () {
  let dt = new Date();
  notEqual(undefined, dt.getTomorrow);
});

it("Should return tomorrow's date.", function () {
  let dt = new Date("August 15, 1947 00:00:00");

  let tomorrowTest = dt.getTomorrow();

  let tomorrowActual = new Date("August 16, 1947 00:00:00");

  equal(tomorrowActual.getDate(), tomorrowTest.getDate());
  equal(tomorrowActual.getMonth(), tomorrowTest.getMonth());
  equal(tomorrowActual.getFullYear(), tomorrowTest.getFullYear());
});

it("Should handle month overflow.", function () {
  let dt = new Date("January 1, 2020 00:00:00");
  let febFirst = new Date("February 1, 2020 00:00:00");

  let nextMonth = dt.getTomorrow();

  for(let i = 3; i <= 31; i += 1) {
    nextMonth = nextMonth.getTomorrow(); 
  }

  nextMonth = nextMonth.getTomorrow();

  equal(nextMonth.getDate(), febFirst.getDate());
});
