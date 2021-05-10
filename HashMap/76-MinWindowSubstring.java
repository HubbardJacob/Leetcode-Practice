/*
  L
      R           
"ADOBECODEBANC"   t = "ABC"


min length = 6
indexes = [0, 5]

Hash Map


 have = 3              need = 3
windowMap               t Map
 A->1                   A->1
 D->1                   B->1
 O->1                   C->1
 B->1
 E->1
 C->1
 N->1
*/
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0){
            return "";
        }
        
        HashMap<Character, Integer> windowMap = new HashMap();
        HashMap<Character, Integer> tMap = new HashMap();
        
        for(char c : t.toCharArray()){
            if(!tMap.containsKey(c)){
                tMap.put(c, 0);
            }
            tMap.put(c, tMap.get(c) + 1);
        }
        
        int minLength = Integer.MAX_VALUE;
        int minL = -1;
        int minR = -1;
        
        int have = 0;
        int need = tMap.size();
        
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            
            if(!windowMap.containsKey(c)){
                windowMap.put(c, 0);
            }
            windowMap.put(c, windowMap.get(c) + 1);
            
            if(tMap.containsKey(c) && tMap.get(c) == windowMap.get(c)){
                have++;
            }
            
            while(have == need){
            
                if((r - l + 1) < minLength){
                    minLength = (r - l + 1);
                    minL = l;
                    minR = r;
                }
                
                char toRemove = s.charAt(l);
                windowMap.put(toRemove, windowMap.get(toRemove) - 1);
                
                if(tMap.containsKey(toRemove) && windowMap.get(toRemove) < tMap.get(toRemove)){
                    have--;
                }
                
                l++;
            }
        }
        
        if(minLength != Integer.MAX_VALUE){
            return s.substring(minL, minR + 1);
        }
        else{
            
            return "";
        }
         
        
    }
}


