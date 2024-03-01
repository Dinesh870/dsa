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
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        // Stack<Integer> stack = new Stack<>();
        // ListNode temp = head;
        // while(temp != null) {
        //     stack.push(temp.val);
        //     temp = temp.next;
        // }
        // temp = head;
        // while(temp != null) {
        //     if(temp.val != stack.peek()) return false;

        //     stack.pop();
        //     temp = temp.next;
        // }
        // return true;

        // method 2
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);

        while(head != null && head2 != null) {
            if(head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
        
    }
}