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
    void reverse(List<Integer> list) {
        int i = 0, j = list.size()-1;
        while(i <= j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int size = 0;
        while(head != null) {
            int t = k;
            List<Integer> temp = new ArrayList<>();
            while(t > 0 && head != null) {
                temp.add(head.val);
                head = head.next;
                t--;
                size++;
            }
            list.add(temp);
        }
        for(int i = 0; i < list.size() && size-k >= 0; i++) {
            reverse(list.get(i));
            size -= k;
        }
        head = null;
        ListNode temp = null;
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).size(); j++) {
                if(head == null) {
                    head = new ListNode(list.get(i).get(j));
                    temp = head;
                } else {
                    temp.next = new ListNode(list.get(i).get(j));
                    temp = temp.next;
                }
            }
        }
        return head;
    }
}