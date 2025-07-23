//Approach-1 (Using same concept as Permutation-I but keeping count to avoid duplicates)
//T.C : O(N * N!)
//S.C : O(N)

/*
Step 1 : find Unique Permutation for that we take :
         Map<> map -> store occurance of each element 
         List<> temp -> store unique permutation

Step 2 : Find Unique Permutation Using backTracking
         create Method bactracking(map,temp){
        
         Iterate Over the Map 
         base case temp.size() == n; return;
         then Do something  add value intor temp and decrease map frequency  
         Explore Further : make Recursive call
         Undo it : backtrack remove value from temp and put into map      
         }
Step 3 : Return unique Permutation result

 */

class Solution {

  List<List<Integer>> result = new ArrayList<>();
  private int n;

    public void backtrack(List<Integer> temp, Map<Integer,Integer> map){

        //Base case
        if(temp.size() == n){
            result.add(new ArrayList<>(temp));
        }

        //Iterate Over map 
        for(Map.Entry<Integer,Integer> entry : map.entrySet() ){

            int num = entry.getKey();
            int freq = entry.getValue();

            //when count is O skip
            if(freq == 0){
                continue;
            }

            //DO Something
            temp.add(num);
            map.put(num,freq-1);//decrese count 

            //Explore further 
            backtrack(temp,map);

            //undo it 
            temp.remove(temp.size()-1);
            map.put(num,freq);
 
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        
      n = nums.length;

    List<Integer> temp = new ArrayList<>();
    
    //count occurance of number 
    Map<Integer,Integer> map = new HashMap<>();

     // Count the occurrence of each number
     for(int num : nums){

        map.put(num,map.getOrDefault(num,0)+1);
     }


    backtrack(temp,map);
    return result;

    }





}