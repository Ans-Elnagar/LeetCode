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
    public void reorderList(ListNode head) {
        if(head.next == null || head.next.next == null)
            return;
        reverse(head, head);
    }
    private ListNode reverse(ListNode current, ListNode head){
        if(current.next == null){
            ListNode temp = head.next;
            head.next = current;
            current.next = temp;
            return temp;
        }
        ListNode subHead = reverse(current.next, head);
        if(subHead == null)
            return subHead;
        if(subHead == current){
            subHead.next = null;
            return null;
        }
        ListNode temp = subHead.next;
        subHead.next = current;
        current.next = temp;
        if(temp == current){
            temp.next = null;
            return null;
        }
        return temp;
    }
}