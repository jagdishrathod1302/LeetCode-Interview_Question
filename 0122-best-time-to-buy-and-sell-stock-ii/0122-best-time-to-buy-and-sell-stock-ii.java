//Approach : Simple Iterative 
// T C : O(n)
// S C : O(1)

/*
Step 1: compare the current day prices with previous day like that prices[i] > prices[i-1]
Step 2 : then add current day and previous day to max_Profit max_profit += (prices[i]-prices[i-1])
 */
class Solution {
  
    public int maxProfit(int[] prices) {

     int n = prices.length;

     int max_profit = 0;

     for(int i=1; i<prices.length; i++){

          if(prices[i] > prices[i-1]){

                max_profit += (prices[i] - prices[i-1]);
          }

     }
    
     return max_profit;
        
    }
}