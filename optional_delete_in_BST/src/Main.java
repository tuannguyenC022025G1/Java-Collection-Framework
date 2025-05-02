public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        // Thêm node
        int[] values = {25, 20, 5, 12, 22, 36, 30, 28, 40, 38, 45};
        for (int val : values) {
            tree.insert(val);
        }

        System.out.print("Cây trước khi xóa: ");
        tree.inorder();

        tree.delete(20); // thử xóa node có 2 con
        System.out.print("Cây sau khi xóa 20: ");
        tree.inorder();

        tree.delete(5); // thử xóa node không có con phải
        System.out.print("Cây sau khi xóa 5: ");
        tree.inorder();
    }
}
