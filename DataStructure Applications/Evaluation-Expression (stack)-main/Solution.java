import java.util.Scanner;



class Node{
     Object item;
     Node next;
     
}


 class MyStack  {
    
    static int size =0;
     Node top;
    
     public int size() {
         return size;
     }
     
     
    public void push(Object element) {
        Node node =new Node();
        node.item=element;
        node.next=top;
        top=node;
        size++;
    }
    
    public boolean isEmpty()
   {
      if(top==null)
          return true;
      return false;
   }
     public Object pop() {
         if(isEmpty())
            throw new NullPointerException();
         else {
             Node node =new Node();
             node=top;
             top=top.next;
             size--;
             return node.item;
         }
     }
     public Object peek() {
         if(isEmpty())
                throw new NullPointerException();
             else {
                 Node node =new Node();
                 node=top; 
                 return node.item;
             }
     }
     
     
     void display() {
         Node n=top;
         int i=0;
         
         System.out.print("[");
         while(n!=null) {
             System.out.print(n.item);
              if(i!=size()-1) {
                  System.out.print(", ");
                  i++;
              }
              n= n.next;
              
         }
         System.out.print("]");
     }
}




 interface IExpressionEvaluator {

public String infixToPostfix(String expression);

public int evaluate(String expression);
}


public class Evaluator  implements IExpressionEvaluator {
    static int a;
    static int b;
    static int c;
     public int precedence(char op) {
         switch(op) {
         case'+':
         case'-':
             return 1;
         case'*':
         case'/':
             return 2;
         case'^':
             return 3;         
         }
         return -1;
     }
     
   
    public  String infixToPostfix(String expression)
   {
         if(expression.charAt(0)=='*' || expression.charAt(0)=='+' || expression.charAt(0)=='^' ||expression.charAt(0)=='/' )
                throw new NullPointerException();
           if(expression.charAt(expression.length()-1)=='*' || expression.charAt(expression.length()-1)=='+' || expression.charAt(expression.length()-1)=='^'||  expression.charAt(expression.length()-1)=='/'|| expression.charAt(expression.length()-1)=='-')
                 throw new NullPointerException();
        Evaluator r =new Evaluator();
       String res = new String("");
       MyStack stack = new MyStack();
       for (int i = 0; i<expression.length(); ++i)
       {
           char c = expression.charAt(i);
           if(i!=0)
             if(Character.isLetter(expression.charAt(i-1))&&Character.isLetter(expression.charAt(i)))
               throw new NullPointerException();
           
           //it is letter or digit
           if (Character.isLetterOrDigit(c)) {
               res += c;   
           }
           else if (c == '(')
               stack.push(c);
                
           
           else if (c == ')')
           {
               while (!stack.isEmpty() &&(char)stack.peek() != '(') {
                    //put all the operands in the string and delete till find start of parenthesis
                     res += stack.pop();
               }
                   stack.pop();
           }
           // If it is operator
           else 
           {
               
               while (!stack.isEmpty() && r.precedence(c)<= r.precedence((char)stack.peek())){
                 
                   res += stack.pop();
            }
            
               stack.push(c);
               
           }
           
           
     
       }
     
       // pop all the operators from the stack
       while (!stack.isEmpty()){
           //in case the brackets is not closed
           if((char)stack.peek() == '(')
               throw new NullPointerException();
           res += stack.pop();
        }
       return res;
   }
    public static int value(char ch) {
          switch(ch) {
           case'a':  
               return a;
           
           case 'b':
               return b;
           
           
           case'c':
               return c;
           
           default : 
               throw new NullPointerException();
          }
    }
    
    public int evaluate(String expression) {
        MyStack stack = new MyStack();
        if(expression.length()==1){
            stack.push(value(expression.charAt(0)));
            stack.push((int)stack.pop()); 
        }
          

        for(int i=0;i<expression.length();i++) {
            
            char c= expression.charAt(i);
              if(stack.size()==1 && c=='-') {
           stack. push( -1*(int)stack.pop());
            
        }     
            if(Character.isLetter(c)) {
               int val=value(c);
               
                stack.push(val);
             
            }
            else {
                if(stack.size()==1 && c=='-') {
                       stack.push( -1*(int)stack.pop());
                       
                   }         
               int val1=(int)stack.pop();
               int val2;
             
               
            switch(c)
           {
               case '+':
                   val2=(int)stack.pop();
                stack.push(val2+val1);
                 
                break;
                 
               case '-':
                   if(stack.size()==0)
                       val2=0;
                   else
                      val2=(int)stack.pop();
                   
                 stack.push(val2- val1);
                  break;
                 
               case '/':
                   val2=(int)stack.pop();
               stack.push(val2/val1);
               break;
                 
               case '*':
                   val2=(int)stack.pop();
               stack.push(val2*val1);
               break;
               
               case'^':
                   val2=(int)stack.pop();
                   if (val1<0) {
                       stack.push(0);
                   }else {
                    stack.push((int)Math.pow(val2, val1));
                   }
                    break; 
               default:
                   throw new NullPointerException();
                    
         }    
             
   }
           
            
 }
       
   return (int)stack.pop();    
}
 
        
   
   public static void main(String[] args)
   {
       Evaluator r =new Evaluator();
       Scanner input = new Scanner(System.in);
       String s=input.next();
    s= s.replace("^--", "^").replace(")--", ")+").replace("+--", "+").replace("/--", "/").replace("a--", "a+").replace("b--", "b+").replace("c--", "c+").replace("--", "");
   
    a= Integer.parseInt(input.next().substring(2));
    b= Integer.parseInt(input.next().substring(2));
    c= Integer.parseInt(input.next().substring(2));
   
       try {
          
          String post =r.infixToPostfix(s);
          int res=r.evaluate(post);
         System.out.println(post);
          System.out.println(res);
       

       }catch(Exception ex) {
           System.out.print("Error");
           System.exit(0);
       }
      
   }
}
    
     
     
