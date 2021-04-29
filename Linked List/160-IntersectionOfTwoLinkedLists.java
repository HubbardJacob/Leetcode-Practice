
/*

We can just keep resetting the heads until they eventually end up on the same node.

*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode currA = headA;
        ListNode currB = headB;
        
        
        while(currA != null || currB != null){
            
            if(currA == null){
                currA = headB;
            }
            if(currB == null){
                currB = headA;
            }
            
            if(currA == currB){
                return currA;
            }
            
            currA = currA.next;
            currB = currB.next;
        }
        
        return null;
    }   
}
