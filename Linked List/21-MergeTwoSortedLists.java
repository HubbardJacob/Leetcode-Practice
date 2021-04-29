

/*
           l1
3 -> 2 -> null

    l2
1 -> 5 -> 4 -> 3 -> 2
    
    
 1 -> 3 -> 2
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode();
        ListNode dummyHead = curr; // this is a pointer to the beginning of our list
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        
        if(l1 == null){
            curr.next = l2;
        }
        else{
            curr.next = l1;
        }
        
        return dummyHead.next;
    }
}
