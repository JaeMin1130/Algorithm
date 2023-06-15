import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    String data;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode() {
        leftChild = rightChild = null;
    }

    public TreeNode(String data) {
        this.data = data;
        leftChild = rightChild = null;
    }

    public TreeNode(String data, TreeNode left, TreeNode right) {
        this(data);
        if (left.data.equals(".")) {
            this.leftChild = null;
        } else {
            this.leftChild = left;
        }
        if (right.data.equals(".")) {
            this.rightChild = null;
        } else {
            this.rightChild = right;
        }
    }
}

class Tree {
    static TreeNode root;
    static Map<String, TreeNode> map = new HashMap<>();
    static String key = "A";

    static TreeNode setTree(TreeNode pointer, TreeNode prev) {
        if (map.isEmpty()) {
            return null;
        }
        if (pointer == null) {
            pointer = root = map.get(key);
            map.remove(key);
            return setTree(pointer, prev);
        } else {
            prev = pointer;
            if (pointer.leftChild != null) {
                key = pointer.leftChild.data;
                if (map.containsKey(key)) {
                    pointer.leftChild = map.get(key);
                    map.remove(key);
                    pointer = pointer.leftChild;
                    setTree(pointer, prev);
                }
            }
            if (prev.rightChild != null) {
                key = prev.rightChild.data;
                if (map.containsKey(key)) {
                    prev.rightChild = map.get(key);
                    map.remove(key);
                    pointer = prev.rightChild;
                    setTree(pointer, prev);
                }
            }
            return null;
        }
    }

    static void inorder() {
        inorder(root);
    }

    static void preorder() {
        preorder(root);
    }

    static void postorder() {
        postorder(root);
    }

    static void inorder(TreeNode CurrentNode) {
        if (CurrentNode != null) {
            inorder(CurrentNode.leftChild);
            System.out.print(CurrentNode.data);
            inorder(CurrentNode.rightChild);
        }
    }

    static void preorder(TreeNode CurrentNode) {
        if (CurrentNode != null) {
            System.out.print(CurrentNode.data);
            preorder(CurrentNode.leftChild);
            preorder(CurrentNode.rightChild);
        }
    }

    static void postorder(TreeNode CurrentNode) {
        if (CurrentNode != null) {
            postorder(CurrentNode.leftChild);
            postorder(CurrentNode.rightChild);
            System.out.print(CurrentNode.data);
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");
            Tree.map.put(arr[0], new TreeNode(arr[0], new TreeNode(arr[1]), new TreeNode(arr[2])));
        }

        Tree.setTree(null, null);
        Tree.preorder();
        System.out.println();
        Tree.inorder();
        System.out.println();
        Tree.postorder();
    }
}