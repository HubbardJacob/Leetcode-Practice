
/*
imagine a graph where a course 'u' points to its preq 'v'
Build adj matrix with hashmap. 
do dfs. 
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 1){
            return true;
        }
        
        HashMap<Integer, List<Integer>> reqMap = new HashMap();
        
        for(int i = 0; i < numCourses; i++){
            
            if(!reqMap.containsKey(i)){
                reqMap.put(i, new ArrayList());
            }
    
            
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            
            int curCourse = prerequisites[i][0];
            int curPreq = prerequisites[i][1];
            reqMap.get(curCourse).add(curPreq);
            
        }
        for(int i = 0; i < numCourses; i++){
            
            if(!dfs(reqMap, new HashSet(), i)){
                return false;
            }
    
            
        }
        return true;
    }
    
    private boolean dfs(HashMap<Integer, List<Integer>> reqMap, HashSet<Integer> seenCourses, int curCourse){
        if(reqMap.get(curCourse).size() == 0){
            return true;
        }
        if(seenCourses.contains(curCourse)){
                return false;
        }
        seenCourses.add(curCourse);
        for(int i = 0; i < reqMap.get(curCourse).size(); i++){
            int preReq = reqMap.get(curCourse).get(i);
            
            
            if(!dfs(reqMap, seenCourses, preReq)){
                return false;
            }
            
        }
        seenCourses.remove(curCourse);
        reqMap.put(curCourse, new ArrayList());
        return true;
        
    }
}
