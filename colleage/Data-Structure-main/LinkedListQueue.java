package testlab6;


import java.util.Scanner;

public class LinkedListQueue implements IQueue  {
    class Qnode{
        Object data;
        Qnode next;
        Qnode(Object data){
            this.data =data;
        }
    }
    
    Qnode front ,rear;
    static int size=0;
     
    public boolean isEmpty() {
        return size==0;
    }
    public int size()    {
          return size;
      } 
    
    public void prinnntrev(Qnode n)
    {
 
        while(n.next!=null){
            n=n.next;
            prinnntrev(n);
            System.out.print(n.data +", ");
            return;
        }
         
    }
    
    public void display() {
        
        Qnode n = front;
        System.out.print("[");
        if(!isEmpty()){
        prinnntrev(n);
        System.out.print(n.data);
        }
        System.out.print("]");
    }
    
      
    
    
     public void enqueue(Object item) {
         Qnode node = new Qnode(item);
         //node.data=item;
         node.next=null;
          if (isEmpty()) {
              rear=node;
              front=node;
              
          }else {
          rear.next=node;
          rear=node;
         }    
     size++;
    }
     
     public Object dequeue() {
         Object element;
         if(isEmpty())
             throw new RuntimeException();
         //in case one element
         else if(rear==front){
             element= front.data; 
             front=null;
             rear=null;
             size--;
              return element;
         }
         else {
             element= front.data; 
             front =front.next;
             size--;
                return element;
         }
        
     }
     
    public static void main(String[] args) {
        LinkedListQueue r =new LinkedListQueue();
    
     Scanner input =new Scanner(System.in);
     String sin =input.nextLine().replaceAll("\\[|\\]", "");
     String[] s = sin.split(", ");
     
     
     
     
     if (s.length != 1 || !(s[0].isEmpty())) {
          
           for(int i =s.length-1; i>=0; --i){
              r.enqueue ((Object)Integer.parseInt(s[i]));
           }
     }
     String option =input.nextLine();
     try{
         switch(option) {
     
     case "isEmpty":{
         if(r.isEmpty())
             System.out.print("True");
         else
             System.out.print("False");      
     };break;
     case "size":{
         System.out.print(r.size());
     };break;
     case "enqueue":{
         Object x =input.nextInt();
         r.enqueue(x);
         r.display();
     };break;
     case "dequeue":{
         r.dequeue();
         r.display();
     };break;
    
     }
       
     }catch(RuntimeException e) {
         System.out.print("Error");
     }
    
    
   }   
    
      
}
