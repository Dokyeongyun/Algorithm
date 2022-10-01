package leetcode._2_Add_Two_Numbers;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * Constraints:
 * [1] The number of nodes in each linked list is in the range [1, 100].
 * [2] 0 <= Node.val <= 9
 * [3] It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode curNode = temp;

        int additional = 0;
        while (l1 != null || l2 != null || additional != 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = additional + x + y;
            additional = sum / 10;

            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return temp.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
