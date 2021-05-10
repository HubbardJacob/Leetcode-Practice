
/*
Better solution: the first string starts as the prefix, decrease 1 everytime a word does not have the last char
*/


class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 1){
            return strs[0];
        }
        if(strs.length < 2){
            return "";
        }
        
        
        
        int i = 0;
        int j = 0;
        int longestIndex = -1;
        while(i < strs[0].length() && j < strs[1].length() && strs[0].charAt(i) == strs[1].charAt(j) ){
            String prefix = strs[0].substring(0, i+1);
            if(matchesRest(prefix, strs, i)){
                longestIndex = i;
            }
            i++;
            j++;
        }
        if(longestIndex != -1){
            return strs[0].substring(0, longestIndex + 1);
        }
        else{
            return "";
        }
        
    }
    
    private boolean matchesRest(String prefix, String[] strs, int endIndex){
        
        
        for(String str : strs){
            if(endIndex >= str.length()){
                return false;
            }
            if(!prefix.equals(str.substring(0, endIndex+1))){
                return false;   
            }
        }
        return true;
    }
}










