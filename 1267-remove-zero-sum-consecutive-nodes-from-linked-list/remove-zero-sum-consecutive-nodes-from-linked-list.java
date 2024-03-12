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
    public ListNode removeZeroSumSublists(ListNode head) {
         Map<Integer, ListNode> sumToFarthestNodeMap = new HashMap<>();
        
        // Need the dummy node to track the new head if changed.
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        
        // First iteration to compute the map.
        int sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            sumToFarthestNodeMap.put(sum, p);
        }
        
        // Second iteration to re-connect the nodes to the farthest node where the sum stays unchanged
        sum = 0;
        for (ListNode p = preHead; p != null; p = p.next) {
            sum += p.val;
            p.next = sumToFarthestNodeMap.get(sum).next;
        }
        
        // Done, return the head from preHead
        return preHead.next;
    }
}