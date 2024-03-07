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
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        int t = k;
        temp = head;
        ListNode first = head;
        while(t > 1) {
            t--;
            first = first.next;
        }
        int last = size - k + 1;
        ListNode lastNode = head;
        while(last > 1) {
            lastNode = lastNode.next;
            last--;
        }
        // System.out.println(first.val + " " + lastNode.val);
        int x = first.val;
        first.val = lastNode.val;
        lastNode.val = x;
        return head;
    }
}