package leetcode.remove_linked_list_elements;

public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        // 最简单的情况
        if (head == null) {
            return null;
        }

        // 更小的问题的答案
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        (new Solution3()).removeElements(head, 6);
        System.out.println(head);
    }

}
