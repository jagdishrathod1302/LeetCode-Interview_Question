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
=======================================================================================================================
 //Approach-3 (Sliding Window) - ACCEPTED
//T.C : O(m+n)
//S.C : O(26)
/*
  Step 1:If check s1 is larger than s2, no permutation can exist
  Step 2:Frequency arrays for s1 and the current window in s2
  Step 3:Fill frequency of characters in s1
  Step 4:Slide the window over s2
  Step 5:int i = 0; // left index of the sliding window ,int j = 0; // right index of the sliding window
  Step 6:Include a new character from the right end of the window
  Step 7 : Check if the current window size matches the size of s1
  Step 8 : If we have passed the size of s1, we need to remove the leftmost character
  Step 9 : Check if the current window's frequency matches s1's frequency
  Step 10 : No matching window found
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        // If s1 is larger than s2, no permutation can exist
        if (n > m) return false;

        // Frequency arrays for s1 and the current window in s2
        int[] s1_freq = new int[26];
        int[] s2_freq = new int[26];

        // Fill frequency of characters in s1
        for (int i = 0; i < n; i++) {
            s1_freq[s1.charAt(i) - 'a']++;
        }

        // Slide the window over s2
        int i = 0; // left index of the sliding window
        int j = 0; // right index of the sliding window
        while (j < m) {
            // Include a new character from the right end of the window
            s2_freq[s2.charAt(j) - 'a']++;

            // Check if the current window size matches the size of s1
            if (j - i + 1 > n) {
                // If we have passed the size of s1, we need to remove the leftmost character
                s2_freq[s2.charAt(i) - 'a']--;
                i++;
            }

            // Check if the current window's frequency matches s1's frequency
            if (Arrays.equals(s1_freq, s2_freq)) {
                return true;
            }

            j++;
        }

        // No matching window found
        return false;
    }
}
