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
    public ListNode insertionSortList(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        while(size-- > 1) {
            ListNode t1 = head;
            ListNode t2 = head.next;
            while(t2 != null) {
                if(t1.val > t2.val) {
                    int x = t1.val;
                    t1.val = t2.val;
                    t2.val = x;
                }
                t1 = t2;
                t2 = t2.next;
            }
        }
        return head;
    }
}