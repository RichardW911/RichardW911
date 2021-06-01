import java.util.*;

class BSTree {
    static class BSNode {
        public int val;
        public BSNode left;
        public BSNode right;
        public BSNode(int val) {
            this.val = val;
        }
    }

    public BSNode root = null;
    public BSNode search(int val) {
        if(root == null) {
            return null;
        }
        BSNode cur = root;
        while (cur != null) {
            if(val < cur.val) {
                cur = cur.left;
            }else if(val > cur.val) {
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }

    public  boolean insert(int val) {
        BSNode bsNode = new BSNode(val);
        if(root == null) {
            root = bsNode;
            return true;
        }
        BSNode cur = root;
        BSNode parent = null;
        while (cur != null) {
            if(cur.val == val) {
                return false;
            }else if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        if(parent.val < val) {
            parent.right = bsNode;
        }else {
            parent.left = bsNode;
        }
        return true;

    }
    public void remove(int val) {
        if(root == null) {
            return;
        }
        BSNode cur = root;
        BSNode parent = null;
        while(cur != null) {
            if(cur.val == val) {
                removeNode(parent,cur,val);
                return;
            }else if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {

            }
        }
    }
    public void removeNode(BSNode parent,BSNode cur,int val) {
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(parent.left == cur) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else {
            if(cur == root) {
                root = cur.left;
            }else if(parent.left == cur) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }
    }
}


public class BinarySearchTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BSTree bsTree = new BSTree();
        bsTree.insert(4);
        bsTree.insert(3);
        bsTree.insert(1);
        bsTree.insert(15);
        bsTree.insert(11);
        try {
            System.out.println(bsTree.search(11));
        }catch (NullPointerException e) {
            System.out.println("NULL");
            e.printStackTrace();
        }
    }
}

