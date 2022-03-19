import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
       /* Array numbers =new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
       // System.out.println(numbers.indexOf(200));
        //numbers.print();*/
////////////////////////////////////////////////////////
       /* var list =new linkedList();
        var arr=list.toArray();

        list.addLast(10);
        list.addLast(60);
        list.addLast(70);
        list.addLast(30);

        list.FindMiddle();
       // list.removeLast();

        System.out.println(list.size());
        list.reverse();
       var array=list.toArray();
       System.out.println(Arrays.toString(array));
      */
      ////////////////////////////////////////
     /* String str ="{((1+2))}";
      StackApplications exp =new StackApplications();
      var result =exp.isBalancedExpression(str);
      System.out.println(result);*/
//////////////////////////////
       /* Stack stack=new Stack();
        stack.push(10);
        stack.push(500);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.pop());*/
       //////////////////////
        //built in Queue: Queue is an interface but  can use class ArrayDeque<> which can add from front and back
       /*
        Queue <Integer> queue=new ArrayDeque<>();
       queue.add(10);
       queue.add(300);
       queue.add(20);
       queue.add(50);
       reverse(queue);
       System.out.println(queue);*/
        //////////////////////////////////////////////
        ArrayQueue queue =new ArrayQueue(5);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

    }
    //Queue application
    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack= new Stack();
        while(!queue.isEmpty())
            stack.push(queue.remove());
        while(!stack.empty())
            queue.add(stack.pop());

    }



}
