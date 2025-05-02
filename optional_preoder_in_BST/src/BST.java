public class BST<E extends Comparable<E>> {
    TreeNode<E> root;

    // Phương thức chèn phần tử vào BST
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

    // Duyệt cây theo thứ tự Preorder: Node -> Left -> Right
    public void preorder() {
        System.out.print("Duyệt Preorder: ");
        preorder(root);
        System.out.println();
    }

    private void preorder(TreeNode<E> node) {
        if (node == null) return;
        System.out.print(node.element + " ");
        preorder(node.left);
        preorder(node.right);
    }
}