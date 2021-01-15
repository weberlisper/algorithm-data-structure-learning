package leetcode.remove_linked_list_elements;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 先删掉头节点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prevNode = head;
        while (prevNode.next != null) {
            if (prevNode.next.val == val) {
                ListNode delNode = prevNode.next;
                prevNode.next = delNode.next;
                delNode.next = null;
            } else {
                prevNode = prevNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        (new Solution()).removeElements(head, 6);
        System.out.println(head);
    }
}
