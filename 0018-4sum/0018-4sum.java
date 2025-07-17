//Approach : Using Two Pointer
// T C : O(n log n + n^3)
// S C : O(n) -> for list
/*
step 1 : Sort Array 
step 2 : then think about 4 pointer like nums[i]+nums[j]+nums[p]+nums[q]
step 3 : then start loop i to n and j =i+1 to n
step 4 : calculate sum then give condition sum > target -> p++, sum<target ->q--;
or target == sum then add result 4 nums[i]+nums[j]+nums[p]+nums[q]
step 5: 3 optimize to avoid duplicate of all pointer i,j,p
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        Arrays.sort(nums); // Sort the array for two-pointer approach

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate i

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicate j

                int p = j + 1, q = n - 1;

                while (p < q) {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];

                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;

                        // Skip duplicate p
                        while (p < q && nums[p] == nums[p - 1]) p++;

                        // Skip duplicate q
                        while (p < q && nums[q] == nums[q + 1]) q--;
                    }
                }
            }
        }

        return result;
        
    }
}