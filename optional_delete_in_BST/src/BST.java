public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    public BST() {
        root = null;
    }

    // Thêm phần tử vào BST
    public boolean insert(E e) {
        if (root == null) {
            root = new TreeNode<>(e);
            return true;
        }

        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                return false; // trùng lặp
            }
        }

        if (e.compareTo(parent.element) < 0)
            parent.left = new TreeNode<>(e);
        else
            parent.right = new TreeNode<>(e);

        return true;
    }

    // Duyệt giữa (inorder)
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(TreeNode<E> node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.element + " ");
        inorder(node.right);
    }

    // Xóa phần tử khỏi BST
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        // Tìm node cần xóa và cha của nó
        while (current != null && !current.element.equals(e)) {
            parent = current;
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) return false; // Không tìm thấy

        // Trường hợp 1: Không có con trái
        if (current.left == null) {
            if (parent == null) {
                root = current.right; // Xóa root
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            // Trường hợp 2: Có con trái
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element; // Thay giá trị

            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }

        return true;
    }

    // Lớp TreeNode bên trong
    private static class TreeNode<E> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }
}
