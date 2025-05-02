public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        int[] values = {27, 14, 35, 10, 19, 31, 42};

        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("Tìm 19: " + tree.search(19));   // true
        System.out.println("Tìm 100: " + tree.search(100)); // false
    }
}
