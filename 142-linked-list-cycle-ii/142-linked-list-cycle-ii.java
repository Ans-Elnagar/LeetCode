/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        LinkedList<ListNode> list = new LinkedList<>();
        list.add(head);
        while(head.next != null){
            if(list.contains(head.next))
                return head.next;
            list.add(head.next);
            head = head.next;
        }
        return null;
    }
}