//Approach :(Swapping elements in nums)
// T C : O(n!*n)
// S C : O(n!)
/*
Step 1 : first we check the posibility for each number in the array
Step 2 : Make a copy of the current permutation and add to result
Step 3 : Do 1-> Swap the number, 2-> Recursive call Explore number, 3-> swap back the array this is backtracking  
 */
class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();

     private void Solve(int idx, List<Integer> list){

       //Base case 
       if(idx == n){
        result.add(new ArrayList(list));
        return;
       }

       //for finding Permutation 

       for(int i=idx; i<n; i++){

          //swap the number 
          Collections.swap(list,i,idx);

          //Recursive call 
          Solve(idx+1,list);

          //Swap Back
          Collections.swap(list,i,idx);
       }

     }
    public List<List<Integer>> permute(int[] nums) {

     n = nums.length;

      List<Integer> list = new ArrayList<>();

     // Make a copy of the current permutation and add to result
     for(int num : nums){
           list.add(num);
     }

     Solve(0,list);
     return result;

    }
}