//Approach : Using (BinarySearch)
// T C : O(n log)
// S C : O(1)
class Solution {
    public int findMin(int[] nums) {

       int n = nums.length;

       int start = 0;
       int end = n-1;

       while(start < end){

         int mid = start+(end-start)/2;

         if(nums[mid] > nums[end]){

            start = mid+1;
        
         }else if(nums[mid] < nums[end]){
        
            end = mid;
        
         }else{
        
            end--;
        
         }
    
       }
  
      return nums[start];

    }
}