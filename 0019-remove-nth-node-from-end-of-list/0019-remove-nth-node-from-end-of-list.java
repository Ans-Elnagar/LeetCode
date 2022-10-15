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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        removeNth(dummyHead, n);
        return dummyHead.next;
    }
    private int removeNth(ListNode node, int n){
        if(node.next == null)
            return 2;
        int index = removeNth(node.next, n);
        if(index-1 == n)
            node.next = node.next.next;
        return index+1;
    }
}