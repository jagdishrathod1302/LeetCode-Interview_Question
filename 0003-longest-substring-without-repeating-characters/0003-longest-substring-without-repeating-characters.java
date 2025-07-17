//Approach : - (Using two pointer)
// T C : O(n)
// S C : O(1) ->because Set contain only 256 character values 
/*
 s = " a b c a b c b b "
Step 1 : Initialize pointer left = 0, and and take Set<> and int mazLength = 0;
Step 2 : first start interation through right pointer
Step 3 : then start one loop for left pointer remover character from Set
Step 4 : add character in Set and then calculate length then return maxLength
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {

     int left = 0;
     int maxLenght = 0;

     Set<Character> Charset = new HashSet<>();

     for(int right =0; right < s.length(); right++){

           //remove from set 
            while(Charset.contains(s.charAt(right))){
                 
                Charset.remove(s.charAt(left));
                left++;

            }

       //adding in the set 
       Charset.add(s.charAt(right));
       maxLenght = Math.max(maxLenght,right-left+1);
     }

     return maxLenght;
       
    }
}