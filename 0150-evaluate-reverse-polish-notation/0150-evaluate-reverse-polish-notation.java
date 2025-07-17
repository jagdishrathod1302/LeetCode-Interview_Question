//Approach : (Using UnOrderMap and Lambda)
// T C : O(n)
// S C : O(n)

public class Solution {
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int result = 0;

        //Create UnOrderMap 
         Map<String,BiFunction<Integer,Integer,Integer>> map = new HashMap<>();

        //stored Values into map  
         map.put("+", (a,b) -> a+b);
         map.put("-", (a,b) -> a-b);
         map.put("*", (a,b) -> (int) ((long)a * (long)b));
         map.put("/", (a,b) -> a/b);


        for (String s : tokens) {

           
         if(map.containsKey(s)){

            //step 1 : first pop the 2 elements
            //step 2 : then push in the stack result
            
                int b = st.pop();
                int a = st.pop();

              result = map.get(s).apply(a,b); //apply() is the method of BiFunction
              st.push(result);         
            
            } else {
                
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }
}