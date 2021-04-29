/*
Create frequency map.

Create minHeap based on that frequency, always keeping min frequent at the top.

If we go over capacity, just remove top of minheap.

We can then just poll our minheap until empty adding to output
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap();
        
        for(int num : nums){
            if(freqMap.containsKey(num)){
                freqMap.put(num, freqMap.get(num)+1); 
            }
            else{
                freqMap.put(num, 0);
            }
        }
        
        
        PriorityQueue<Integer> minHeap = new PriorityQueue((num1, num2) -> Integer.compare(freqMap.get(num1), freqMap.get(num2)));
        
        
        
        for(int key : freqMap.keySet()){
            minHeap.add(key);
            if(minHeap.size() > k) minHeap.remove();
        }
        
        int[] res = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()){
            res[i] = minHeap.poll();
            i++;
        }
        
        return res;
    }
}
