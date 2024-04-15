/*************************************************
 File: Assignment4
 By: Antonio Gonzalez
 Date: 04/12/2024
 Description: Assignment 4 Binary Search Tree.

 *************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("Assignment 4, part 2: Testing BST\n");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //(a) Insertion of elements into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(80);
        tree.insert(60);
        tree.insert(70);

        //(d) In-order traversal of the tree
        System.out.println("Inorder traversal of the given tree");
        tree.inorder();
        //(b) Deletion of elements from the tree
        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        //(b) Deletion of elements from the tree
        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        //(b) Deletion of elements from the tree
        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        //(d) In-order traversal of the tree
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        //(e) Pre-order traversal of the tree
        System.out.println("\nPreorder traversal of tree is ");
        tree.preorder();
        //(f) Post-order traversal of the tree
        System.out.println("\nPostorder traversal of tree is ");
        tree.postorder();
        //(c) Search for an element in the tree
        System.out.println("\nSearch for 70 in the tree : " + tree.search(70));
        System.out.println("Search for 100 in the tree : " + tree.search(100));
    }
}
