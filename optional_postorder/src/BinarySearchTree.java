public class BinarySearchTree {
    Node root;


    void postOrder(Node node) {
        if (node == null)
            return;

        // Bước 1: Duyệt cây con bên trái
        postOrder(node.left);

        // Bước 2: Duyệt cây con bên phải
        postOrder(node.right);

        // Bước 3: Truy cập nút gốc
        System.out.print(node.data + " ");
    }

    // Gọi hàm duyệt từ nút gốc
    void postOrderTraversal() {
        postOrder(root);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(27);
        tree.root.left = new Node(14);
        tree.root.right = new Node(35);
        tree.root.left.left = new Node(10);
        tree.root.left.right = new Node(19);
        tree.root.right.left = new Node(31);
        tree.root.right.right = new Node(42);

        System.out.println("Postorder:");
        tree.postOrderTraversal();
    }
}
