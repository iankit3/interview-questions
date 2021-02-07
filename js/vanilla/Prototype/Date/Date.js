/**
 * Implement method getTomorrow on a date object.
 * Asked at Walmart Labs.
 */

 Date.prototype.getTomorrow = function() {
   const dt = new Date(this);
   const today = dt.getDate();
   dt.setDate(today + 1);
   return dt;
 }
