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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode temp = head.next.next;
        head.next.next = null;
        oddEvenList(head, head.next, temp, 3);
        return head;
    }
    private void oddEvenList(ListNode oddTail, ListNode evenTail, ListNode node, int i){
        if(node == null)
            return;
        ListNode temp = node.next;
        if(i % 2 == 1){
            ListNode evenHead = oddTail.next;
            oddTail.next = node;
            oddTail = oddTail.next;
            oddTail.next = evenHead;
        }else{
            evenTail.next = node;
            evenTail = evenTail.next;
            evenTail.next = null;
        }
        oddEvenList(oddTail, evenTail, temp, i+1);
    }
}