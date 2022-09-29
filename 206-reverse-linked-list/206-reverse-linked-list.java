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
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        return reverse(head, null);
    }
    private ListNode reverse(ListNode node, ListNode parent){
        if(node.next == null){
            node.next = parent;
            return node;
        }
        ListNode head = reverse(node.next, node );
        node.next = parent;
        return head;
    }
}