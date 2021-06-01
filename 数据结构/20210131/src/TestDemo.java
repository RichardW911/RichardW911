import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;

public class TestDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BTNode root = binaryTree.createTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        System.out.println("=======================");
        binaryTree.inOrderTraversal(root);
        System.out.println();
        /*System.out.println("=======================");
        binaryTree.postOrderTraversal(root);
        System.out.println();
        System.out.println("=======================");
        binaryTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        System.out.println(binaryTree.getKLevelSize(root, 1));
        System.out.println(binaryTree.getHight(root));*/

        binaryTree.preOrderTraversalNor(root);
        System.out.println();
        binaryTree.inOrderTraversalNor(root);
    }
}



