/**
 * Created by chinh on 25/11/2014.
 */
public class LinkedList {
    class Node{
        int value;
        Node next;
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    Node head;
    void addHead(int x){
        Node newNode = new Node(x, head);
        head = newNode;
    }

    static boolean isPanlindrome;
    static Node start;
    static boolean check(Node cur){
        boolean ret = true;
        if(cur.next!=null) ret &= check(cur.next);
        ret &= (cur.value==start.value);
        start = start.next;
        return ret;
    }


    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addHead(0);
        linkedList.addHead(1);
        linkedList.addHead(2);
        linkedList.addHead(2);
        linkedList.addHead(1);
        linkedList.addHead(0);
        start = linkedList.head;
        isPanlindrome = true;
        System.out.println(check(start));
    }
}
