public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        int[] values = {27, 14, 35, 10, 19, 31, 42};

        for (int value : values) {
            tree.insert(value);
        }

        tree.preorder();
    }
}