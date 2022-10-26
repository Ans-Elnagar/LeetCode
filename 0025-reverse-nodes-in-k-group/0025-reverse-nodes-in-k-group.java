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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode prevToCurrentHead = dummyHead;
        ListNode nextPart;
        while(head != null){
            int tempK = k-1;
            while(tempK > 0 && head != null){
                head = head.next;
                tempK--;
            }
            if(tempK != 0 || head == null)
                break;
            nextPart = head.next;
            head.next = null;
            prevToCurrentHead.next = reverseLinkedList(prevToCurrentHead.next, null);
            // update prev
            while(prevToCurrentHead.next != null)
                prevToCurrentHead = prevToCurrentHead.next;
            prevToCurrentHead.next = head = nextPart;
        }
        return dummyHead.next;
    }
    private ListNode reverseLinkedList(ListNode node, ListNode parent){
        if(node.next == null){
            node.next = parent;
            return node;
        }
        ListNode head = reverseLinkedList(node.next, node);
        node.next = parent;
        return head;
    }
}