
/*
// Use a hashmap, Each node in the original one maps to a newly created node with no connections.
// Do another pass, for every node in original one, lookup in the hashmap, set its next to original next, 
// set random to random
{node : node}

1-> 2 -> 3 -> 4
|   |    |    |
1   2    3    4


nodeMap.get(1).next = node.next;
nodeMap.get(1).random = node.random;
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        
        HashMap<Node, Node> nodeMap = new HashMap<Node, Node>();
        
        Node curr = head;
        
        while(curr != null){
            nodeMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr != null){
            nodeMap.get(curr).next =  nodeMap.get(curr.next);
            nodeMap.get(curr).random = nodeMap.get(curr.random);
            curr = curr.next;
        }
        
        return nodeMap.get(head);
    }
}



