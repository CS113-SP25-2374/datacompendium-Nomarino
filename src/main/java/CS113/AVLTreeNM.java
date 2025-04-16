package CS113;

public class AVLTreeNM<E extends Comparable<E> & CS113.interfaces.Comparable<E>> extends BinarySearchTreeNM<E> {
    Node<E> rotateLeft(Node<E> node) {
        Node<E> childRight = node.right;
        node.right = childRight.left;
        childRight.left = node;
        node = childRight;
        return node;

    }
    Node<E> rotateRight(Node<E> node) {
        Node<E> childLeft = node.left;
        node.left = childLeft.right;
        childLeft.right = node;
        node = childLeft;
        return node;
    }

    int balanceFactor (Node<E> node) {
        if (node == null) {
            return 0;
        }
        return heightRecursive(node.right) - heightRecursive(node.left);
    }

    Node<E> rebalance(Node<E> node, E element) {
        int balance = balanceFactor(node);
        if (balance >= -1 && balance <= 1)
        { return node; }
        if (balance > 1) {
            if (balanceFactor(node.right) < 0) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        } else if (balance < -1) {
            if (balanceFactor(node.left) > 0) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        }
        return node;
    }

    @Override
    Node<E> insertRecursive(Node<E> node, E element) {
    node = super.insertRecursive(node, element);
    node = rebalance(node, element);
    return node;
    }
}

