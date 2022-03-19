import java.util.Arrays;

public class Stack {
    private int[] items =new int[5];
    private int count;
    public void push(int item){
        if(count==items.length)
            throw new StackOverflowError();
        items[count++]=item;
    }
    public int pop(){
        if(count==0)
            throw new IllegalStateException();
        return items[--count];
    }
    @Override
    public String toString(){
        //to copy array
        var arr=Arrays.copyOfRange(items,0,count);
        return Arrays.toString(arr);
    }
    public int peek(){
        return items[count-1];
    }
}
