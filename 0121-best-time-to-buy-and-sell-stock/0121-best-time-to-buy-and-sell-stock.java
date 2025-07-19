//Approach : Simple Iterative 
// T C : O(n) Linear
// S C : O(1)

/*
Step 1 : First we can sell prices[0] index we sell remain prices from array
Step 2: so then we take Varicable best_buy = prices[0]; store 0th index value and calculate minimum 
Step 3 : so we Iterate Remaining array and calculate max_Profit
Step 4 : first the prices[i] > best_busy then i calculate maximum Profit
Step 5 : then we substract best_busy value and current prices[i] value prices[i]-best_buy in Max Caluculation
*/

class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

          int best_buy = prices[0];
          int maxProfit = 0;

          for (int i=1; i<n; i++){

               //prices greter than best buy then we caculate max Profit 
              if(prices[i] > best_buy){
                  maxProfit = Math.max(maxProfit,prices[i]-best_buy);
              }
              best_buy = Math.min(best_buy,prices[i]);
          }
        return maxProfit;
    }
}