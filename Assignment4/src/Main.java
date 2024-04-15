/*************************************************
 File: Assignment4
 By: Antonio Gonzalez
 Date: 04/12/2024
 Description: Assignment 4 Binary Search Tree.

 *************************************************/
public class Main {
    public static void main(String[] args) {
        System.out.println("\nAssignment 4, part 2: Testing BST\n");
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //(a) Insertion of elements into the tree
        tree.insert(7);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        tree.insert(9);
        tree.insert(1);
        tree.insert(4);
        tree.insert(10);
        tree.insert(15);

        //(d) In-order traversal of the tree
        System.out.println("Inorder traversal of the given tree");
        tree.inorder();
        //(b) Deletion of elements from the tree
        System.out.println("\nDelete 2");
        tree.deleteKey(2);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        //(b) Deletion of elements from the tree
        System.out.println("\nDelete 3");
        tree.deleteKey(3);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
        //(b) Deletion of elements from the tree
        System.out.println("\nDelete 5");
        tree.deleteKey(5);
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
        System.out.println("\nSearch for 7 in the tree : " + tree.search(7));
        System.out.println("Search for 100 in the tree : " + tree.search(100));
    }
}

/*
    Program sample output below.
 */

/*
Assignment 4, part 2: Testing BST

Inorder traversal of the given tree
1
2
3
4
5
6
7
8
9
10
15

Delete 2
Inorder traversal of the modified tree
1
3
4
5
6
7
8
9
10
15

Delete 3
Inorder traversal of the modified tree
1
4
5
6
7
8
9
10
15

Delete 5
Inorder traversal of the modified tree
1
4
6
7
8
9
10
15

Preorder traversal of tree is
7
4
1
6
8
9
10
15

Postorder traversal of tree is
1
6
4
15
10
9
8
7

Search for 7 in the tree : true
Search for 100 in the tree : false

Process finished with exit code 0
 */