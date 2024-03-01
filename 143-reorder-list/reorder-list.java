/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head;
        while(temp != null) {
            curr = temp.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }
        // while(prev != null){
        //     System.out.print(prev.val+" ");
        //     prev = prev.next;
        // }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode temp = head;

        head2 = reverse(head2);
        
        while(temp != null && head2 != null) {
            ListNode th = temp.next;
            ListNode th2 = head2.next;

            temp.next = head2;
            // temp = temp.next;
            head2.next = th;
            temp = th;
            head2 = th2;
        }
    }
}