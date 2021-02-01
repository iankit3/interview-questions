
// LC-70 EASY - https://leetcode.com/problems/climbing-stairs/
// GFG - https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/
// Nutanix
function stairs(totalStairs){
    let dp = new Array(totalStairs+1);
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
  
    for(let i=4; i<dp.length; ++i){
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    }
    
    return dp[totalStairs];
  }
  
  stairs(5)