// LC-122 EASY - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
// Nutanix

function maxProfit(prices) {
  let maxprofit = 0;
  for (let i = 1; i < prices.length; i++) {
    if (prices[i] > prices[i - 1]) maxprofit += prices[i] - prices[i - 1];
  }
  return maxprofit;
}
