/*
Use their alphabet counts as a key in a hashmap, hashmap points to list of all the anagrams.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        
        HashMap<String, List<String>> anagramMap = new HashMap();
        
        
        for(String str : strs){
            int[] counts = new int[26];
            for(char c : str.toCharArray()){
                counts[c - 'a']++;
            }
            
            StringBuilder keyToAddBuilder = new StringBuilder();
            
            for(int count : counts){
                keyToAddBuilder.append(count + "#");
            }
            
            String keyToAdd = keyToAddBuilder.toString();
            if(!anagramMap.containsKey(keyToAdd)){
                anagramMap.put(keyToAdd, new ArrayList());
                anagramMap.get(keyToAdd).add(str);
            }
            else{
                anagramMap.get(keyToAdd).add(str);
            }
        }
        
        List<List<String>> result = new ArrayList();
        
        for(String key : anagramMap.keySet()){
            result.add(anagramMap.get(key));
        }
        
        return result;
        
    }
}



