package leetcode.reverse_linked_list;

// 206
public class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

}
