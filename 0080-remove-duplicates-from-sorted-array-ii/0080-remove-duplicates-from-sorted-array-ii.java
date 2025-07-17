//Approach (Two Pointer)
// T C : O(n)
// S C : O(1)
/*
Step 1: first initialize two pointer left = 2 , right = 2
Step 2: second start the loop find two unique element nums[left-2] != nums[rigth]
Step 3: return size of array return left
*/


class Solution { 
    public int removeDuplicates(int[] nums) {

      int n = nums.length;

      int left = 2;
      int right = 2;

      if(n <= 2){
         return n;
      }

       while(right < n){

         if(nums[left-2] != nums[right]){

                 nums[left] = nums[right];
                 left++;
         }
         
          right++;
       }

       return left;
    }
}