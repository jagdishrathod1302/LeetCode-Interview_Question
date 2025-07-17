// Approach : (Recursion + BackTracking)
//T.C : O(n * 2^n) - For a string of length n, there are 2^(\U0001d45b − 1) potential ways to partition it (since each position can either be a cut or not). and we also check palindrome O(n)
//S.C : O(n * 2^n) - Number of partitions * their length
//-------------------------------------------------------------
/*
Step 1 : First check String is Palindrom or not add partion into current List the make recursive call to partition a list
Step 2 :  after that all partion of palindrom string add into result 
Step 3 : then Backtrack the current list and then chek String from i+1 "aa"
Step 4 : then again do same process until the next partition don 
 */
class Solution {
   private int n;

    //Check palindrom or not 
    public boolean isPalindrom(String s,int l, int r){

      while(l < r){

         if(s.charAt(l) != s.charAt(r)){
            return false;
         }

         l++;
         r--;

      }
 
     return true;
 
    }

    public void backtracking(String s,int idx,List<String> curr, List<List<String>> result){

        n = s.length();
       
       //base case 
       if(idx == n){
           result.add(new ArrayList(curr));
           return;
       }

       for(int i=idx; i<n; i++){
 
          if(isPalindrom(s,idx,i)){

              //add string in current list 
              curr.add(s.substring(idx,i+1));
               
            //recursive call 
            backtracking(s,i+1,curr,result);

            //Backtracking 
            curr.remove(curr.size()-1);

          }

       }
    }
    
    public List<List<String>> partition(String s) {

     List<String> curr = new ArrayList<>();
     
     List<List<String>> result = new ArrayList<>();

     backtracking(s,0,curr,result);

       return result;
    }
}