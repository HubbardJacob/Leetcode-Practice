/*
                           f
                       s
                    [4,2,1,3]
         s f          
        [4,2]                 [1,3]
    
    [4]      [2]           [1]      [3]


        [2,4]       
*/

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode left = head;
        ListNode right = getMid(head);
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;
        
        
        left = sortList(left);
        right = sortList(right);
        
        ListNode result = merge(left, right);
        
        
        return result;
    }
    
    private ListNode merge(ListNode list1, ListNode list2){
        ListNode curr = new ListNode();
        ListNode newHead = curr;
        
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        if(list1 != null){
            curr.next = list1;
        }
        else if(list2 != null){
            curr.next = list2;
        }
        
        return newHead.next;
    }
    
    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}