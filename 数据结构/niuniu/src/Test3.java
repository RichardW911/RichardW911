import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.reflect.*;
public class Test3 {
    Solution solution = new Solution();


}

class Solution {
    int res = -127;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(0,root.left.val);
        int right = Math.max(0,root.right.val);

        res = Math.max(res,left + right + root.val);
        return (left + right) + root.val;
    }
}



class DumpMethods {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName(args[0]);
        Method m[] = c.getDeclaredMethods();
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i].toString());
        }
    }
}

class main {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;

        Solution99 solution99 = new Solution99();
        boolean res = solution99.isCousins(node1,5,4);
        System.out.println(res);
        Arrays.sort(new int[1]);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution99 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isX = false;
        boolean isY = false;
        while(!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                if (cur.val == x) {
                    isX = true;
                }else if (cur.val == y) {
                    isY = true;
                }


                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

            if (isX && isY) {
                break;
            } else {
                isX = false;
                isY = false;
            }
        }
        return isX;
    }
}
