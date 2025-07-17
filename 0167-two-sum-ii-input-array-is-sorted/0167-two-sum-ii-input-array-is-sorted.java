//Approach (Two Pointer)
// T C : O(n)
// S C : O(1) -> constant space 
class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;
 
        int  i = 0;
        int j = n-1;

        while(i < j){

           if(numbers[i]+numbers[j] ==  target){

                  return new int[]{i+1,j+1};  // for 1 base index        
            }
            else if(numbers[i]+numbers[j] < target){
                i++;
            }else{

                j--;
            }
 
        }
        return new int[] {};
    }
}
// Note : return new int[] {i+1 , i+j } : question required one base index so we take i+1,j+1