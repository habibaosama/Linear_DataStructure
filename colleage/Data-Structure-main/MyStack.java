package Testlab5;

import java.util.Scanner;
 
public class MyStack  implements IStack{
    class Node{
         Object item;
         Node next;
     }
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
     
     public static void main (String[] args) {
         MyStack newStack =new  MyStack();
           
          Scanner input =new Scanner(System.in);
          String sin =input.nextLine().replaceAll("\\[|\\]", "");
          String[] s = sin.split(", ");
          String option =input.nextLine();
          
          
          
          if (s.length != 1 || !(s[0].isEmpty())) {
               
                for(int i = s.length-1; i >=0; --i)
                    newStack.push( Integer.parseInt(s[i]));
                        
          }
          try { 
              switch(option) {
              case"push":{
                  int x=input.nextInt();
                 newStack.push(x);
                 newStack.display();
              };break;
              
              case"peek":{
                  
                  System.out.print(newStack.peek());
              };break;
              
              case"pop":{
                  newStack.pop();
                  newStack.display();
              };break;
              case"isEmpty":{
                  if(newStack.isEmpty())
                      System.out.print("True");
                  else
                      System.out.print("False");
              };break;
              case"size":{
                  System.out.print(newStack.size());
              };break;
              default:
                  System.out.print("Error") ;           
              }
              
             } catch( NullPointerException ex) {
               System.out.print("Error");  
             }
             
             
     }
     
     
     

}
