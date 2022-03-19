public class Array {
    private int items[];
    private int count;


    public  Array(int length){
        items=new int[length];
    }
    public void print(){
        for(int i=0;i< count;i++)
            System.out.println(items[i]);
    }

    public void insert(int item){
        if(count==items.length){
            int[] newitems=new int[count*2];
            for(int i=0 ;i<count;i++)
                newitems[i]=items[i];
            items=newitems;
        }
       items[count++]=item;
    }
    public void removeAt(int index){
        if(index<0 ||index>=count)
            throw new IllegalArgumentException();
        //shift the items
        for(int i=index;i<count;i++)
            items[i]=items[i+1];
        count--;

    }

    public int indexOf(int item){
        for(int i=0;i<count;i++){
            if(items[i]==item)
                return i;
        }
        return-1;
    }


}
