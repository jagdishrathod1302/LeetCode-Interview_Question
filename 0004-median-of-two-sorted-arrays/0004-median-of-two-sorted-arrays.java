//Approach :- Brut force 
// T C :- O(m+n) -> nums1 = m and nums2 = n
// S C :- O(m+n)
/*
  step 1 : Create one temp[] Array to store nums1 & nums2 element in it  
  step 2 : we initialize pointer nums1 = i and nums2 = j and temp -> k
  step 3 : compare element nusm1 and nums2 small element first store in temp
  step 4 : when iteration will be out of bound like nums1 or nums2 then remaing element store as it is 
  step 5 : then temp size will be even we return temp[size/2];
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 
      int m = nums1.length; 
      int n = nums2.length;


     int[] temp = new int[m+n];

     int i = 0; // point nums1 
     int j = 0; // point nums2
     int k = 0; // point temp 
 
     //Here we took small element 
     while(i < m && j < n){

         if(nums1[i] < nums2[j]){

            temp[k++] = nums1[i++];
         }else{

              temp[k++] = nums2[j++];
         }
     }

    //here as it store value of nums1
    while(i < m){
             temp[k++] = nums1[i++];
    }


    //here as it is store value of nums2
    while(j < n){

          temp[k++] = nums2[j++];
    }

    int size = m+n;

    //for even temp size  
    if(size%2 != 0){
        return temp[size/2];
    }

     return (temp[size/2] + temp[size/2-1])/2.0;



    }
}