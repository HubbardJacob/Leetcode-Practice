/*
// illegal strings
openRem = 1
closerem = 0
())




                            ""   n = 2 openRem = 2 closeRem = 2
                           /
          openRem = 1   "("   
                        /  \
        openRem = 0   "((" "()"     openRem = 1  closeRem = 1
                      /      \
      closeRem = 1 "(()"      "()("   openRem = 0  closeRem = 1
                    /           \
closeRem = 0     "(())"           "()()" openRem = 0  closeRem = 0
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        helper("", result, n, n);
        
        return result;
    }
    
    private void helper(String current, ArrayList<String> result, int openRem, int closeRem){

        if(openRem == 0 && closeRem == 0){
            result.add(current);
            return;
        }
        
        if(openRem > 0) helper(current+"(", result, openRem - 1, closeRem); // if we have open remaining
        if(openRem < closeRem) helper(current+")", result, openRem, closeRem - 1); // 
    }
}