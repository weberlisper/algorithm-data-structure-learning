package leetcode.remove_linked_list_elements;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr cannot null or empty!");
        }

        this.val = arr[0];
        ListNode curNode = this;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode curNode = this;
        while (curNode != null) {
            res.append(curNode.val).append(" -> ");
            curNode = curNode.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
