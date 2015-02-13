/**
 * Created by chinh on 25/11/2014.
 */
public class BinarySearchTree {
    int size=0;
    class Node{
        int value;
        Node left, right, parent;
        public Node(int x){
            this.value = x;
        }
    }
    Node root;
    public BinarySearchTree(){}
    public BinarySearchTree(Node root){
        this.root = root;
    }
    public void add(int x){
        if(isEmpty()){
            root = new Node(x);
            size++;
            return;
        }
        Node cur = root;
        while(x!=cur.value){
            if(x<cur.value){
                if(cur.left==null){
                    cur.left = new Node(x);
                    cur.left.parent = cur;
                    size++;
                }
                cur = cur.left;
            } else {
                if(cur.right==null){
                    cur.right = new Node(x);
                    cur.right.parent = cur;
                    size++;
                }
                cur=cur.right;
            }
        }
    }
    public boolean isEmpty(){
        return size==0;
    }
    public Node find(int x){
        Node cur = root;
        while(cur!=null && cur.value!=x){
            if(x<cur.value){
                cur = cur.left;
            } else{
                cur = cur.right;
            }
        }
        return cur;
    }
    public Node smallest(){
        Node cur=root;
        while(cur!=null && cur.left!=null){
            cur = cur.left;
        }
        return cur;
    }
    public void remove(int x){
        Node cur = find(x);
        if(cur==null) return;
        size--;
        if(cur.left==null && cur.right==null){
            Node parent = cur.parent;
            if(parent==null){
                root=null;
                return;
            }
            if(parent.left==cur) parent.left=null; else parent.right=null;
        } else
        if(cur.left!=null && cur.right!=null){
            BinarySearchTree subTree = new BinarySearchTree(cur.right);
            int value = subTree.smallest().value;
            remove(value);
            cur.value = value;
        } else{
            Node parent = cur.parent;
            Node child = cur.left!=null ? cur.left : cur.right;
            if(parent==null) root = child; else
            if(parent.left==cur){
                parent.left = child;
                child.parent = parent;
            } else{
                parent.right=child;
                child.parent=parent;
            }
        }
    }

    public Node ceiling(int x){
        Node cur = root;
        while(true){
            if(cur.value==x) return cur;
            if(x<cur.value){
                if(cur.left==null){
                    return cur;
                }
                cur = cur.left;
            } else{
                if(cur.right==null){
                    while(cur.parent!=null && cur==cur.parent.right) cur=cur.parent;
                    return cur.parent;
                }
                cur = cur.right;
            }
        }
    }
}
