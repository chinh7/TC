package codeforce;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



public class R279D2F {
    static public class BinarySearchTree {
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


    static int[] a, cursor, edges;
    static boolean[] visited;
    static int ret = 1;
    static int ret2 = 1;
    static ArrayList<Integer> stack = new ArrayList<Integer>();
    static BinarySearchTree bst = new BinarySearchTree();
    static int find(int value){
        int l=0, r=stack.size()-1;
        while(l<r){
            int mid = (r-l)/2+l;
            if(stack.get(mid)>=value) r=mid; else l=mid+1;
        }
        if(stack.get(l)<value) return stack.size(); else return l;
    }
    static void visit(int i){
        ret = Math.max(ret, stack.size());
        ret2 = Math.max(ret2, bst.size);
        visited[i] = true;
        for(int e=cursor[i]; e<cursor[i+1]; e++){
            int j = edges[e];
            if(!visited[j]){
                int index = find(a[j]);
                BinarySearchTree.Node node = bst.ceiling(a[j]);
                if(index==stack.size()){
                    if(node!=null) System.out.println("Panic");
                    stack.add(a[j]);
                    bst.add(a[j]);
                    visit(j);
                    stack.remove(stack.size()-1);
                    bst.remove(a[j]);
                } else{
                    int tmp = stack.get(index);
                    stack.set(index, a[j]);
                    node.value = a[j];
                    visit(j);
                    stack.set(index, tmp);
                    node.value = tmp;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] x = new int[n-1];
        int[] y = new int[n-1];
        cursor = new int[n+1];
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken())-1;
            y[i] = Integer.parseInt(st.nextToken())-1;
            cursor[x[i]]++; cursor[y[i]]++;
        }
        for(int i=0; i<n; i++) cursor[i+1] += cursor[i];
        edges = new int[2*(n-1)];
        for(int i=0; i<n-1; i++){
            edges[--cursor[x[i]]] = y[i];
            edges[--cursor[y[i]]] = x[i];
        }
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            Arrays.fill(visited, false);
            stack.add(a[i]);
            bst.add(a[i]);
            visit(i);
            stack.remove(0);
            bst.remove(a[i]);
        }
        System.out.println(ret2);
    }
}
