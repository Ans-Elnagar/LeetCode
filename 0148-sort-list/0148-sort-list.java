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
    public ListNode sortList(ListNode head) {
        if(head == null)
            return head;
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return sort(head, size);
    }
    private ListNode sort(ListNode node, int size){
        if(size == 2){
            if(node.val > node.next.val){
                int temp = node.val;
                node.val = node.next.val;
                node.next.val = temp;
                
            }
        } else if(size > 2){
            int leftSize = size/2;
            int rightSize = size - leftSize;
            ListNode rightStart = node;
            for(int i=0; i<leftSize; i++){
                rightStart = rightStart.next;
            }
            node = sort(node, leftSize);
            rightStart = sort(rightStart, rightSize);
            // merge
            int i=0, j=0;
            ListNode dummyHead = new ListNode();
            ListNode current = dummyHead;
            while(i<leftSize && j<rightSize){
                if(node.val < rightStart.val){
                    current.next = node;
                    node = node.next;
                    i++;
                }else{
                    current.next = rightStart;
                    rightStart = rightStart.next;
                    j++;
                }
                current = current.next;
                current.next = null;
            }
            while(i<leftSize){
                current.next = node;
                node = node.next;
                i++;
                current = current.next;
                current.next = null;
            }
            while(j<rightSize){
                current.next = rightStart;
                rightStart = rightStart.next;
                j++;
                current = current.next;
                current.next = null;
            }
            node = dummyHead.next;
        }
        return node;
    }
}