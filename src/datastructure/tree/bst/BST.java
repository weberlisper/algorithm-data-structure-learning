package datastructure.tree.bst;

import utils.ArrayGenerator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    // 宏观语义：向以node为根节点的树中添加e，并且返回添加元素后树的根节点
    private Node add(Node node, E e) {
        // 最简单情况，递归到了null的时候，就是添加元素的地方
        if (node == null) {
            size++;
            return new Node(e);
        }

        // 解决更小的问题
        if (e.compareTo(node.e) > 0) {  // 如果插入元素比当前元素大，则插入到右子树
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {   // 如果插入元素比当前元素小，则插入左子树
            node.left = add(node.left, e);
        }

        // 返回当前问题的解
        return node;
    }

    // 非递归方式插入元素e
    public void addNR(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        }

        Node curNode = root;
        while (true) {
            if (e.compareTo(curNode.e) < 0) {   // 插入左子树
                if (curNode.left == null) {
                    curNode.left = new Node(e);
                    size++;
                    return;
                } else {
                    curNode = curNode.left;
                }
            } else if (e.compareTo(curNode.e) > 0) {    // 插入右子树
                if (curNode.right == null) {
                    curNode.right = new Node(e);
                    size++;
                    return;
                } else {
                    curNode = curNode.right;
                }
            } else {
                return;
            }
        }
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    // 查询以node为根节点的树中是否含有e元素
    private boolean contains(Node node, E e) {
        // 最简单的情况
        if (node == null) {
            return false;
        } else if (node.e.compareTo(e) == 0) {
            return true;
        }

        // 处理更小的问题
        if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {    // e < node.e
            return contains(node.left, e);
        }
    }

    // 前序遍历
    public void preOrder() {
        preOrder(root);
    }

    // 前序遍历以node为根节点的树
    private void preOrder(Node node) {
        // 最简单情况
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 非递归形式前序遍历
    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            System.out.println(curNode);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }

    // 中序遍历
    public void inOrder() {
        inOrder(root);
    }

    // 中序遍历以node为根节点的树
    private void inOrder(Node node) {
        // 最简单情况
        if (node == null) {
            return;
        }

        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }

    // 中序遍历
    public void postOrder() {
        postOrder(root);
    }

    // 后序遍历以node为根节点的树
    private void postOrder(Node node) {
        // 最简单情况
        if (node == null) {
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    // 层序遍历
    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            System.out.println(curNode.e);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }

    // 返回最小的元素值
    private Node minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty! ");
        }

        return minimum(root);
    }

    private Node minimum(Node node) {
        Node curNode = node;
        while (curNode.left != null) {
            curNode = curNode.left;
        }
        return curNode;
    }

    // 删除树中的最小值
    public E removeMin() {
        E ret = minimum().e;
        root = removeMin(root);
        return ret;
    }

    // 宏观语义：删除以node为根节点中最小的元素，并返回删除后的根节点
    private Node removeMin(Node node) {
        // 最简单的情况
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        // 递归删除左子树中的最小值
        node.left = removeMin(node.left);
        return node;
    }

    // 返回最大的元素值
    private Node maximum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BST is empty! ");
        }

        return maximum(root);
    }

    private Node maximum(Node node) {
        Node curNode = node;
        while (curNode.right != null) {
            curNode = curNode.right;
        }
        return curNode;
    }

    // 删除树中的最小值
    public E removeMax() {
        E ret = maximum().e;
        root = removeMax(root);
        return ret;
    }

    // 宏观语义：删除以node为根节点中最大的元素，并返回删除后的根节点
    private Node removeMax(Node node) {
        // 最简单的情况
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        // 递归删除右子树中的最大值
        node.right = removeMax(node.right);
        return node;
    }

    public E remove(E e) {
        return remove(root, e).e;
    }

    // 宏观语义，删除以node为根节点中的元素e
    public Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ArrayGenerator.generateOrderIntArray(8)));
    }
}
