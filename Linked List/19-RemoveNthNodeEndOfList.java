/*

Input: head = [1,2,3,4,5], n = 2

[1,2]
 2
     c d
[1,2,3,4,5]
 5 4 3 2
Output: [1,2,3,5]
*/


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null){
            return null;
        }
        if(head.next == null){
            return null;
        }
        
        int node_count = 0;
        
        ListNode curr = head;
        while(curr != null){
            node_count++;
            curr = curr.next;
        }
        
        if(node_count == n){ //if we want to remove the first one
            return head.next;
        }
        
        curr = head;
        ListNode to_delete = head.next;
        
        while(node_count >= 0){
            if(node_count == n+1){
                curr.next = to_delete.next;
                break;
            }
            curr = curr.next;
            to_delete = to_delete.next;
            node_count--;
        }
        
        return head;
    }
}
