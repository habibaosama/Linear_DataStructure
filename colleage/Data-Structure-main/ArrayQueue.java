package testlab6;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;




public class ArrayQueue implements IQueue {
    static int size=0;
    static int MAX=1000;
    static int front=0, rear=MAX-1;
    static Object[] array = new Object[MAX];
    
    public void enqueue(Object item){
        if(size()==MAX){
            throw new RuntimeException();
        }else{
            rear=(rear+1)%MAX;
            array[rear]=item;
            size++;
        }
    }

    public Object dequeue(){
        int temp = 0;
        if(isEmpty()){
            throw new RuntimeException();
        }else{
            temp = (int)array[front];
            array[front]=null;
            front = (front+1)%MAX;
            size--;
        }
                  
        return temp;
    }
 
    public boolean isEmpty(){
        return (size() == 0);
    }
 
    public int size(){
        return size;
    }
    
    public  void display() {
         
         
             System.out.print("[");    
        if(!isEmpty()){
         for(int i =rear ; i!= front ;i=(i-1)%MAX) {
                System.out.print(array[i]);
                  if(i != MAX - 1)
                    System.out.print(", ");
         }
             System.out.print(array[front]);
        }
        System.out.print("]");
     
   }
    
    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      String sin = sc.nextLine().replaceAll("\\[|\\]", "");
      String[] s = sin.split(", ");
       
      ArrayQueue obj = new ArrayQueue();
      if (s.length != 1 || !s[0].isEmpty()){
       
          for(int i = s.length-1; i>=0; i--){
            
             obj.enqueue((Integer.parseInt(s[i])));
          }                             
      }
      
      
      String option =sc.nextLine();
      try{
          switch(option) {
      
      case "isEmpty":{
          if(obj.isEmpty())
              System.out.print("True");
          else
              System.out.print("False");      
      };break;
      case "size":{
          System.out.print(obj.size());
      };break;
      case "enqueue":{
          Object x =sc.nextInt();
          obj.enqueue(x);
          obj.display();
      };break;
      case "dequeue":{
          obj.dequeue();
          obj.display();
      };break;
     
      }
        
      }catch(RuntimeException e) {
          System.out.print("Error");
      }
  } 
    }