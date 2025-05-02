public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    // Phương thức chèn phần tử vào cây
    public void insert(E element) {
        root = insert(root, element);
    }

    private TreeNode<E> insert(TreeNode<E> node, E element) {
        if (node == null) {
            return new TreeNode<>(element);
        }
        if (element.compareTo(node.element) < 0) {
            node.left = insert(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = insert(node.right, element);
        }
        return node;
    }

    // Phương thức tìm kiếm phần tử trong cây
    public boolean search(E element) {
        TreeNode<E> current = root;
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true; // Tìm thấy
            }
        }
        return false; // Không tìm thấy
    }
}
