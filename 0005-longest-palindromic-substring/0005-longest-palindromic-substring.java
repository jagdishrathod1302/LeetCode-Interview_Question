//Approach 2 - Simple Recursion solve()
//T.C : O(n^3)
class Solution {
    //this method check which substring palindrom or not 
    public boolean Solve(String s , int i, int j){

     //base case 
      if(i >= j){
        return true;
      }

      if(s.charAt(i) == s.charAt(j)){

         return Solve(s , i+1, j-1);//Recursive call
      }

     return false;

    }
    public String longestPalindrome(String s) {

     int n = s.length();
    
      int maxLength = 0;
      int startPoint = 0;

      for(int i=0; i<n; i++){

          for(int j=i; j<n; j++){

             //call sovle and get palindrom true
             if(Solve(s,i,j)){ 

                 if((j-i+1) > maxLength){

                    maxLength = j-i+1; //update maxLength
                    startPoint = i;

                 }

             }
          }
      }
      
        return s.substring(startPoint,startPoint+maxLength);
        
    }
}