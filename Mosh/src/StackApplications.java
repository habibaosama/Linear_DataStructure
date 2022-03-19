import java.util.Arrays;
import java.util.List;
import java.util.Stack;
public class StackApplications {
 //NOTES
    //convert string to char array this string.toCharArray()
    //Arrays.asList("","..")


    public String reverseString(String input){
        //to reverse string store in stack
        if(input==null)
            throw  new IllegalArgumentException();

        Stack <Character> stack =new Stack();
        for(char ch :input.toCharArray())
            stack.push(ch);
        //used StringBuffer instead of string if there is alot of concatination
        StringBuffer reversed =new StringBuffer();
        while(!stack.empty())
           reversed.append(stack.pop());
        return reversed.toString();
    }

    private final List<Character> leftBrackets = Arrays.asList('(','[','{','<');
    private final List<Character> rightBrackets = Arrays.asList(')',']','}','>');
    public boolean isBalancedExpression(String input){
        //balanced expression "(1+2> " check using stack
        Stack<Character> stack =new Stack();
        for(char ch: input.toCharArray()){
            if(isLeftBracket(ch))
                stack.push(ch);

            if(isRightBracket(ch)){
                if(stack.empty())return  false;

                var pop= stack.pop();
                if(!bracketMatches(pop,ch)) return false;

            }
        }
       return stack.empty();
    }

    private boolean isLeftBracket( char left){
        return leftBrackets.contains(left);
    }
    private boolean isRightBracket( char right){
        return rightBrackets.contains(right);
    }
    private boolean bracketMatches(char left,char right){
        return leftBrackets.indexOf(left)==rightBrackets.indexOf(right);
    }


}
