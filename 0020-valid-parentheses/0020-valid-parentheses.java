class Solution {
    public boolean isValid(String s) {
        
    Stack<Character> st = new Stack();

     for(char ch : s.toCharArray()){

         if(ch == '('){
            st.push(')');
         }
         else if(ch == '{'){
            st.push('}');
         }
         else if(ch == '['){
            st.push(']');
         }
         else if(st.isEmpty() || st.peek()!= ch){  //for mismatch 
      
                return false;
         }else{
            st.pop();
         }
       
     }
     return st.isEmpty();
   
    }
}