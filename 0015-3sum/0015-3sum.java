//Approach : Using two sum 
// T C : O(n^2)
// S C : O(1)
/*
Step1 : First Iterate over nums array chech n1 is duplicate or not 
Step2 : then create twoSum method under for loop and give parameter 
step3 : then in the twoSum method applly logic of two sum 
*/


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
       int n = nums.length;

       //sort Array
       Arrays.sort(nums);

       List<List<Integer>> result = new ArrayList<>();

      if(n < 3){

           return new ArrayList<>();
      }

      for(int i=0; i<n-2; i++){

           if(i != 0 && nums[i] == nums[i-1]){

               continue;
           }

            twoSum(nums,i+1,result,-nums[i]);
      }

        return result;
    }

    public void twoSum(int[] nums, int k, List<List<Integer>> result, int target){

       int i = k, j = nums.length-1;

       while(i < j){

          if(i < j && nums[i]+nums[j] < target){

                i++;
          }else if(i<j && nums[i]+nums[j] > target){

              j--;
          }
          else{
                result.add(Arrays.asList(-target,nums[i],nums[j]));

               //Handel duplicate
                while (i < j && nums[i] == nums[i+1]){
                    i++;
                }
                while (i < j && nums[j] == nums[j-1]){
                    j--;
                }
                i++;
                j--;

          }
       }

    }


}