// Java program to find length of the longest valid
// substring

import java.util.Stack;

class lvp//Longest valid Parentheses 
{
    // method to get length of the longest valid
    static int findMaxLen(String str)
    {
        int n = str.length();

        // Create a stack and push -1 
        // as initial index to it.
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        // Initialize result
        int result = 0;

        // Traverse all characters of given string
        for (int i = 0; i < n; i++) 
        {
			System.out.print("**i**="+i+ "  ");
            // If opening bracket, push index of it
            if (str.charAt(i) == '('){
                stk.push(i);
					System.out.println("stk 1 = "+stk);
				}
            // // If closing bracket, i.e.,str[i] = ')'
            else 
            {
                // Pop the previous 
                // opening bracket's index
                if(!stk.empty())
                    stk.pop();

                // Check if this length 
                // formed with base of
                // current valid substring 
                // is more than max
                // so far
                if (!stk.empty()){
                    result= Math.max(result, i - stk.peek());
					System.out.println("Result = "+result+ "   stk="+stk);
					}

                else{ // If stack is empty. push 
                // current index as base 
                // for next valid substring (if any)
					stk.push(i);
					System.out.println("stk 2 = "+stk);
				}               
                    
            }
        }

        return result;
    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "((()()";
      System.out.println("str = "+str);
        // Function call
        System.out.println("First stack testing = "+findMaxLen(str));
			System.out.println("------------------------------------------------------");
        str = "()(()))))";
      System.out.println("str = "+str);
        // Function call
        System.out.println("Second stack testing = "+findMaxLen(str));
    }
}