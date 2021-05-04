class Trie {
    
    class TreeNode {
        HashMap<Character, TreeNode> children;
        boolean endOfWord;
        
        
        // Hashmap allows us to say for a character, give me children nodes.
        public TreeNode(HashMap<Character, TreeNode> children){
            this.children = children;
            this.endOfWord = false;
        }
    }
    
    TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode(new HashMap());
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode curr = root;
        
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                curr.children.put(c, new TreeNode(new HashMap())); // Create new node if character is not in trie
            }
        
            curr = curr.children.get(c); // Go to either an existing child, or to the new one we just created. 
        }
        
        curr.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode curr = root;
        
        for(char c : word.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false; // If children does not contain the next letter, it isnt in the tree.
            }
        
            curr = curr.children.get(c); 
        }
        
        return curr.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode curr = root;
        
        for(char c : prefix.toCharArray()){
            if(!curr.children.containsKey(c)){
                return false;
            }
        
            curr = curr.children.get(c); // Go to either an existing child, or to the new one we just created. 
        }
        
        return true;
    }
}