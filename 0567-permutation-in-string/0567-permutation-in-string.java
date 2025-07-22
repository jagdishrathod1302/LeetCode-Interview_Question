//Approach-2 (Using Sorting and Comparing) - ACCEPTED
//T.C : O((m-n) * nlogn) -> sorting and substring of Iteration
//S.C : O(n)
/*
 Step 1 : IF check s1 is longer than s2, it cannot be a substring 
 Step 2 : Sort the String 1
 Step 3 : Iterate over each substring of s2 of length equal to s1
 Step 4 : Extract a substring of length n from s2 starting at index i
 Step 5 : Sort the substring
 Step 6 : If the sorted substring matches the sorted s1, return true
 Step 7 : Other wise return false; 
 */
class Solution {  
    public boolean checkInclusion(String s1, String s2) {
 
      int n = s1.length();
      int m = s2.length();

      // If s1 is longer than s2, it cannot be a substring
      if(n > m){

        return false;
      }

       // Sort the string s1
       char[] sortedS1 = s1.toCharArray();
       Arrays.sort(sortedS1);

       // Iterate over each substring of s2 of length equal to s1
       for(int i = 0; i <= m-n; i++){

           // Extract a substring of length n from s2 starting at index i
           String subString = s2.substring(i,i+n); //for dynamic end i+n
           
           // Sort the substring
           char[] sortedS2 = subString.toCharArray();
           Arrays.sort(sortedS2);

            // If the sorted substring matches the sorted s1, return true
           if(Arrays.equals(sortedS2,sortedS1)){
            return true;
           }

       }
      
       return false;

    }
}