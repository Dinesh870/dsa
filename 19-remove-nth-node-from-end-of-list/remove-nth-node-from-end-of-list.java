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
    int length(ListNode h) {
        int l = 0;
        while(h != null) {
            l++;
            h = h.next;
        }
        return l;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = length(head);
        int posff = len -n+1;
        ListNode curr = head;
        for(int i = 1; i < posff-1; i++) {
            curr = curr.next;
        }
        if(posff == 1) {
            head = head.next;
        }
        else {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = curr.next;
        } 

        return head;
    }
}