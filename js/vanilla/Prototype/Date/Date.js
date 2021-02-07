/**
 * Implement method getTomorrow on a date object.
 */

 Date.prototype.getTomorrow = function() {
   const dt = new Date(this);
   const today = dt.getDate();
   dt.setDate(today + 1);
   return dt;
 }
