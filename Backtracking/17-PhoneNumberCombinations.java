/*
                       23
         /             |               \ 
      a                b                 c
    / | \           /  |  \           /  |  \ 
   d  e  f         d   e   f         d   e   f
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        
        HashMap<Character, String> mappings = new HashMap();
        mappings.put('2', "abc");
        mappings.put('3', "def");
        mappings.put('4', "ghi");
        mappings.put('5', "jkl");
        mappings.put('6', "mno");
        mappings.put('7', "pqrs");
        mappings.put('8', "tuv");
        mappings.put('9', "wxyz");
        
        List<String> output = new ArrayList();
        
        if(digits.length() == 0){
            return output;
        }
        
        helper(digits, "", 0, mappings, output);
        
        return output;
    }
    
    private void helper(String digits, String current, int offSet, HashMap<Character, String> mappings, List<String> output){
        if(current.length() == digits.length()){
            output.add(current);
            return;
        }
        
        char digit = digits.charAt(offSet);
        for(char letter : mappings.get(digit).toCharArray()){
            helper(digits, current+letter, offSet+1, mappings, output);
        }
            
            
        
    }
}
