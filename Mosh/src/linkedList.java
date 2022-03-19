import java.util.NoSuchElementException;

public class linkedList {
    public class Node {
        private int value;
        private Node next;
        public Node(int item){
            this.value=item;
        }

    }
    Node first;
    Node last;
    private int size;
    public void addLast(int item){
        var node=new Node(item);
        if(isEmpty())
            first=last=node;
        else{
            last.next=node;
            last=node;
        }
        size++;
    }
    public void addFirst(int item){
        var node =new Node (item);
        if(isEmpty())
            first=last=node;
        else{
            node.next=first;
            first=node;
        }
        size++;
    }
    public int indexOf(int item){
        int index=0;
        var current=first;
        while(current!=null){
            if(current.value==item)
                return index;
            else{
               current=current.next;
               index++;
            }
        }
        return-1;
    }
    public boolean contains(int item){
        return indexOf(item) !=-1;
    }
    public void removefirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first==last)
            first = last = null;
        else{
            var second=first.next;
            first.next=null;
            first=second;
        }
        size--;
    }
    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first==last)
            first=last=null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }
    public int size(){
        return size;
    }
    public int[] toArray(){
     int[] array=new int[size];
     int index=0;
     var current=first;
     while(current!=null){
         array[index++]=current.value;
         current=current.next;
        }
     return array;
    }
    public void reverse(){
        //[30->20->10]
        //[30<-20<-10]
        //p     c   n
        //       p   c  n
        //           p
        if (isEmpty())
            return;
        var previous =first;
        var current=first.next;
        while(current!=null){
            var nextnext=current.next;
            current.next=previous;
            previous=current;
            current=nextnext;
        }
        last=first;
        last.next=null;
        first=previous;
    }

    public void FindMiddle(){
        //assume we don't know the size
        //for odd linked list
    /*no.of nodes   middle
     1               1
     3               2
     5               3
     7               4
     //so node inc by 2 but middle 1 need 2 pointers
    * */
        //for even
    /*
    no.of nodes   middle
    2              1,2
    4              2,3
    6              3,4
    8              4,5

     */
    //if odd b at the end points at last node while even point at null
        if(isEmpty())
            throw new IllegalStateException();
        var a=first;
        var b=first;
        while(b!=last && b.next!=last){
            b=b.next.next;
            a=a.next;
        }
        if(b==last)
            System.out.println(a.value);
        else
            System.out.println(a.value+" "+a.next.value );
    }





   private Node getPrevious(Node node){
        var current=first;
        while(current!=null){
            if(current.next==node) return current;
            current=current.next;
        }
        return null;
   }
    private boolean isEmpty(){
        return first==null;
    }



}
