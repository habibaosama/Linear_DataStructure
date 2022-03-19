import java.util.Arrays;

public class ArrayQueue {
    private int []items =new int [5];
    private int rear;
    private int front;
    private int count;
    public ArrayQueue(int capacity){
        items=new int[capacity];
    }
    public void enqueue(int item){
        if(count==items.length)
            throw new IllegalStateException();
        //items[rear++]=item;
        items[rear]=item;
        rear=(rear+1)%items.length;
        count++;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
    public int dequeue(){
        int item =items[front];
        //items[front++]=0;
        items[front]=0;
        front= (front+1)%items.length;
        count--;
        return item;
    }
    ///circular array
    /*
    * [60,0,30,20,10]
    *             R
    * index = left %5 which is length
    * 5 -> 0
    * 6-> 1
    * 7 -> 2
    * 8->3
    * 9->4
    * 10 -> 0
    * Rule :(rear+1)%length
    *
    * */


}
