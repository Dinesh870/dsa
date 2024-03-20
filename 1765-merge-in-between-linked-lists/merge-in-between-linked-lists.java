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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode firstPrev = list1;
        ListNode secondPrev = list1;
        while(a > 1) {
            firstPrev = firstPrev.next;
            a--;
        }
        while(b > 0) {
            secondPrev =secondPrev.next;
            b--;
        }
        secondPrev = secondPrev.next;

        ListNode list2Tail = list2;
        while(list2Tail.next!= null) list2Tail =list2Tail.next;

        firstPrev.next = list2;
        list2Tail.next = secondPrev;

        return list1;
    }
}