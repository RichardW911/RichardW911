import java.lang.reflect.Array;
import java.util.Stack;

class BTNode{
    public char val;
    public BTNode left;//左子树
    public BTNode right;//右子树

    public BTNode(char val) {
        this.val = val;
    }
}


public class BinaryTree {
    public BTNode createTree() {
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }

    // 前序遍历
    void preOrderTraversal(BTNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历
    void inOrderTraversal(BTNode root){
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(BTNode root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }
    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(BTNode root) {
        if(root == null) {
            return;
        }
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    // 子问题思路-求结点个数

    int getSize2(BTNode root){
        if(root == null) {
            return 0;
        }
        return getSize2(root.left) + getSize2(root.right) + 1;
    }
    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(BTNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            leafSize ++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(BTNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(BTNode root,int k) {
        if(root == null) {
            return 0;
        }
        if(k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }
    //获取二叉树的高度
    int getHight(BTNode root) {
        int leftHeight = getHight(root.left);
        int rightHeiht = getHight(root.right);
        return leftHeight > rightHeiht ? leftHeight+1 : rightHeiht+1;
    }


    BTNode find(BTNode root,int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        BTNode ret = find(root.left,val);
        if(ret != null) {
            return ret;
        }
        ret = find(root.right,val);
        if(ret != null) {
            return ret;
        }
        return null;
    }
    //前序遍历 非递归
    void preOrderTraversalNor(BTNode root) {
        if (root == null) return;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val);
                cur = cur.left;
            }
            BTNode top = stack.pop();
            cur = top.right;
        }
    }
    //中序遍历 非递归
    void inOrderTraversalNor(BTNode root) {
        if (root == null) return;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.pop();
            System.out.print(top.val);
            cur = top.right;
        }
    }
    //后续遍历 非递归
    void postOrderTraversalNor(BTNode root) {
        if (root == null) return;
        Stack<BTNode> stack = new Stack<>();
        BTNode cur = root;
        BTNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            BTNode top = stack.peek();
            if(top.right == null || top.right == prev) {
                stack.pop();
                System.out.print(top.val);
                prev = top;
            }else {
                cur = top.right;
            }

        }
    }
}
