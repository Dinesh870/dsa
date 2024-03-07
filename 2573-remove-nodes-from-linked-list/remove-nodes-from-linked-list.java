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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        while(head != null) {
            while(!st.isEmpty() && st.peek() < head.val) st.pop();
            st.push(head.val);
            head = head.next;
        }
        head = new ListNode(st.pop());

        while(!st.isEmpty()) {
            ListNode temp = new ListNode(st.pop());
            temp.next = head;
            head = temp;
        }
        return head;
    }
}