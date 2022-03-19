package lab4;

import java.util.*;

class Node {
    int data;
    int pow;
    Node next;
}

class SingleLinkedList {

    public Node head;

    public void show() {
        Node n = head;
        int i = 0, j = size();

        System.out.print("[");

        while (n != null) {
            System.out.print(n.data);
            if (i != j - 1) {
                System.out.print(", ");
                i++;
            }
            n = n.next;
        }
        System.out.print("]");
    }


    //overload
    public void add(int element, int pow) {

        Node node = new Node();
        node.data = element;
        node.pow = pow;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node N = head;
            while (N.next != null) {
                N = N.next;
            }
            N.next = node;
        }

    }

    public void add(Object element) {

        Node node = new Node();
        node.data = (int) element;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node N = head;
            while (N.next != null) {
                N = N.next;
            }
            N.next = node;
        }

    }

    public void add(int index, Object element) {
        if (index < 0)
            throw new NullPointerException();
        Node node = new Node();
        node.data = (int) element;
        node.next = null;
        if (index == 0) {
            Node n = head;
            node.next = head;
            head = node;
        } else {
            Node N = head;
            for (int i = 0; i < index - 1; i++) {
                N = N.next;
            }
            node.next = N.next;
            N.next = node;
        }

    }

    public int size() {
        Node n = head;
        int i = 0;
        while (n != null) {
            n = n.next;
            i++;
        }
        return i;
    }

    public void set(int index, Object element) {
        if (index < 0)
            throw new NullPointerException();
        Node N = head;
        for (int i = 0; i < index; i++) {
            N = N.next;
        }
        N.data = (int) element;

    }


    public void clear() {
        if (size() == 0) {
            return;
        }
        Node N = head;
        while (N.next != null) {
            Node n = N;
            N = N.next;
            n.next = null;
        }
        head = null;
    }

    public boolean isEmpty() {

        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object get(int index) {
        if (index < 0)
            throw new NullPointerException();
        Node n = head;
        while (index > 0) {
            n = n.next;
            index--;
        }

        return n.data;
    }

    public void remove(int index) {
        if (index < 0)
            throw new NullPointerException();
        Node N = head;
        if (index == 0) {
            Node p = head;
            N = N.next;
            head = N;
            p.next = null;

        } else {
            for (int i = 0; i < index - 1; i++) {
                N = N.next;
            }
            Node M, n;
            M = N.next;
            n = M.next;
            N.next = n;
            M.next = null;
        }

    }

    public boolean contains(Object o) {

        Node n = head;
        for (int i = 0; i < size(); i++) {
            if (n == null)
                return false;
            else if (n.data == (int) o)
                return true;
            else
                n = n.next;
        }
        return false;
    }


}


public class Solution implements IPolynomialSolver {


    static HashMap w = new HashMap();

    public static int[][] convertToArray(SingleLinkedList list) {
        int size = list.size();
        Node n = list.head;
        int[][] arr = new int[size][2];
        for (int i = 0; i < size; ++i) {
            arr[i][0] = n.data;
            arr[i][1] = n.pow;
            n = n.next;
        }
        return arr;
    }


    public static int[][] convert(String sin) throws Exception {

        sin = sin.replaceAll("\\[|\\]", "");
        String[] arr = sin.split(",");
        int[][] terms = new int[arr.length][2];
        if (arr.length == 0 || arr[0].isEmpty()) {
            throw new Exception();
        }
        for (int i = 0; i < arr.length; ++i) {
            terms[i][0] = Integer.parseInt(arr[i]);
            terms[i][1] = arr.length - i - 1;
        }

        return terms;
    }

   public  String print(char poly) {
           
          SingleLinkedList list= (SingleLinkedList)w.get(poly);
          String result = "";
          Node n = list.head;
          for(int i=0; i<list.size()-2;i++) {
              
              if(n.data!=0){
                if(n.data==1){
                    result += "x^"+n.pow;
                }
                
                else{
                    result += n.data+"x^" +n.pow;
                }
                
              }
                n=n.next;
            
                if(n.data>0 && result!=""){
                  result += "+";
                }
            
          }
           
          if(n.data!=0 && n.pow==1){
              
             if(n.data==1){
                 result += "x";
                
             }
             else{    
                 result += n.data+"x";
             }   
              n=n.next;
           
                if(n.data>0 && result!=""){
                  result += "+";
                }
              
          }
          
           else {
                  n=n.next;
                  if(n.data>0 && result!=""){
                  result += "+";
                }
              }
         
            if(n.data!=0){
                
              result += n.data;
            }
         
          return result;
      
      
  }


   public  void setPolynomial(char poly, int[][] terms) {
        SingleLinkedList list = new SingleLinkedList();
        for (int i = 0; i < terms.length; i++) {
            list.add(terms[i][0], terms[i][1]);

        }
        w.put(poly, list);
    }

    public  float evaluatePolynomial(char poly, float value) {
        float result = 0;
        SingleLinkedList list = (SingleLinkedList) w.get(poly);
        Node n = list.head;
        for (int i = 0; i < list.size(); i++) {
            result += (float) (n.data * Math.pow((double) value, (double) n.pow));
            n = n.next;
        }

        return result;
    }

    public void clearPolynomial(char poly) {
        SingleLinkedList list = (SingleLinkedList) w.get(poly);
        list.clear();
        list.show();
    }

    public int[][] add(char poly1, char poly2) {
        SingleLinkedList list1 = (SingleLinkedList) w.get(poly1);
        SingleLinkedList list2 = (SingleLinkedList) w.get(poly2);
        SingleLinkedList list3 = new SingleLinkedList();

        Node n = list3.head;
        Node m = list1.head;
        Node o = list2.head;

        int s = list1.size();
        if (list1.size() > list2.size()) {
            s = s - (list1.size() - list2.size());
            for (int i = 0; i < list1.size() - list2.size(); i++) {
                list3.add(m.data, m.pow);
                m = m.next;
            }
        } else if (list2.size() > list1.size()) {
            s = s - (list2.size() - list1.size());
            for (int i = 0; i < list2.size() - list1.size(); i++) {
                list3.add(o.data, o.pow);
                o = o.next;
            }
        }
        for (int i = 0; i < s; i++) {
            int d = m.data + o.data;
            list3.add(d, m.pow);
            m = m.next;
            o = o.next;

        }

        w.put('R', list3);

        return convertToArray(list3);

    }


    public int[][] subtract(char poly1, char poly2) {
        SingleLinkedList list1 = (SingleLinkedList) w.get(poly1);
        SingleLinkedList list2 = (SingleLinkedList) w.get(poly2);
        SingleLinkedList list3 = new SingleLinkedList();

        Node n = list3.head;
        Node m = list1.head;
        Node o = list2.head;

        int s = list1.size();
        if (list1.size() > list2.size()) {
            s = s - (list1.size() - list2.size());
            for (int i = 0; i < list1.size() - list2.size(); i++) {
                list3.add(m.data, m.pow);
                m = m.next;
            }
        } else if (list2.size() > list1.size()) {
            s = s - (list2.size() - list1.size());
            for (int i = 0; i < list2.size() - list1.size(); i++) {
                list3.add(o.data, o.pow);
                o = o.next;
            }
        }
        for (int i = 0; i < s; i++) {
            int d = m.data - o.data;
            list3.add(d, m.pow);
            m = m.next;
            o = o.next;

        }

        w.put('R', list3);
        return convertToArray(list3);


    }

    // Function to add coefficients of same power
    static void removeDuplicates(char poly) {
        SingleLinkedList list3 = (SingleLinkedList) w.get(poly);
        Node ptr1, ptr2, dup;
        ptr1 = list3.head;


        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;


            while (ptr2.next != null) {


                if (ptr1.pow == ptr2.next.pow) {

                    // Add their coefficients and put it in 1st element
                    ptr1.data = ptr1.data + ptr2.next.data;
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;

                } else
                    ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }


    public  int[][] multiply(char poly1, char poly2) {
        SingleLinkedList list1 = (SingleLinkedList) w.get(poly1);
        SingleLinkedList list2 = (SingleLinkedList) w.get(poly2);
        SingleLinkedList list3 = new SingleLinkedList();
        Node n = list1.head;
        Node N = list2.head;
        Node sop = list3.head;
        //Node pro =null;

        int size1 = list1.size(), size2 = list2.size();
        for (int i = 0; i < size1; i++) {
            N = list2.head;
            for (int j = 0; j < size2; j++) {
                int coefR = n.data * N.data;
                int expR = n.pow + N.pow;
                list3.add(coefR, expR);
                N = N.next;
            }

            n = n.next;
        }
        //removeDuplicates(sop);
        w.put('R', list3);
        return convertToArray(list3);

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean s;
        int res;
        Solution obj = new Solution();
        int[][] arr2D;
        int[][] arr;
        while (input.hasNext()) {
            String option = input.nextLine();
            char poly;
            try {
                switch (option) {
                    case "set": {
                        poly = input.nextLine().charAt(0);
                        if (poly != 'A' && poly != 'B' && poly != 'C') {
                            throw new Exception();
                        } else {

                            String sin = input.nextLine();
                            arr2D = convert(sin);
                            obj.setPolynomial(poly, arr2D);
                        }
                    }
                    ;
                    break;
                    case "print": {
                        poly = input.nextLine().charAt(0);
                        String re = obj.print(poly);
                        System.out.println(re);
                    }
                    ;
                    break;
                    case "eval": {
                        poly = input.nextLine().charAt(0);
                        float value = input.nextFloat();
                        res = (int) obj.evaluatePolynomial(poly, value);
                        System.out.print(res);
                    }
                    ;
                    break;
                    case "clear": {
                        poly = input.nextLine().charAt(0);
                        obj.clearPolynomial(poly);
                    }
                    ;
                    break;
                    case "add": {
                        char poly1 = input.nextLine().charAt(0);
                        char poly2 = input.nextLine().charAt(0);

                        obj.add(poly1, poly2);
                        String h = obj.print('R');
                        System.out.println(h);
                    }
                    ;
                    break;

                    case "sub": {
                        char poly1 = input.nextLine().charAt(0);
                        char poly2 = input.nextLine().charAt(0);

                        obj.subtract(poly1, poly2);
                        String h = obj.print('R');
                        System.out.println(h);
                    }
                    ;
                    break;
                    case "mult": {
                        poly = input.nextLine().charAt(0);
                        char poly1 = input.nextLine().charAt(0);
                        arr = obj.multiply(poly, poly1);
                        removeDuplicates('R');
                        String re = obj.print('R');
                        System.out.print(re);
                    };
                    break;
                    default:
                        throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("Error");
                return;
            }

        }
    }

}
