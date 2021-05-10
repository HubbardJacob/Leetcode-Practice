class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        HashMap<Node, Node> cloneMap = new HashMap();
        
        
        return dfs(node, cloneMap);
    }
    
    
    private Node dfs(Node node, HashMap<Node, Node> cloneMap){
        if(cloneMap.containsKey(node)){
            return cloneMap.get(node);
        }
        
        cloneMap.put(node, new Node(node.val));
        for(Node vertex : node.neighbors){
            cloneMap.get(node).neighbors.add(dfs(vertex, cloneMap));
        }
        
        return cloneMap.get(node);
    }
}