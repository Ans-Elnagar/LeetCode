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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;
        ListNode lastNode = check(head.next, head);
        if(lastNode == null)
            return false;
        return lastNode.val == head.val;
    }
    private ListNode check(ListNode node, ListNode head){
        if(node.next == null){
            return head.val == node.val ? head.next: null;
        }
        head = check(node.next, head);
        if(head == null)
            return null;
        if(head.val == node.val)
            return head.next;
        return null;
    }
}