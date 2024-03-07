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
    public ListNode middleNode(ListNode head) {
        // ListNode temp = head;
        // int n= 0;
        // while(temp != null) {
        //     n++;
        //     temp = temp.next;
        // }
        // n /= 2;
        // for(int i = 1; i <= n; i++) {
        //     head = head.next;
        // }
        // return head;

        // Time Complexity = O(n)
        // space complexity = O(1)

        // method 2: in one iteration
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            temp = temp.next.next;
            head = head.next;
        }

        return head;

        // Time Complexity = O(n)
        // space complexity = O(1);

        // method 3: using exttra space
        // ArrayList<ListNode> array = new ArrayList<>();
        // int length = 0;
        // while(head != null) {
        //     array.add(head);
        //     length++;
        //     head = head.next;
        // }
        // return array.get(length/2);

        // time complexity = O(n);
        // space complexity = O(1);
    }
}