class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

           
    //edge cases
    if (newInterval == null) return intervals == null ? new int[0][0] : intervals;
    if (intervals == null || intervals.length == 0) {
      return new int[][] { {newInterval[0], newInterval[1]} };
    }
  
  //create a result
  List<int[]> result = new ArrayList<>();
  
  int i = 0;
  int n = intervals.length;
  int newStart = newInterval[0];
  int newEnd = newInterval[1];
  
  // CASE 1 -- not overlapping with new interval
  while ( i < n && intervals[i][1] < newStart) {
    result.add(new int[] {intervals[i][0], intervals[i][1]});
    i++;
  }
  
  // CASE 2 - merge all the intervals that overlap with the new one 
  while( i < n && intervals[i][0] <= newEnd) {
    newStart = Math.min(newStart, intervals[i][0]);
    newEnd = Math.max(newEnd, intervals[i][1]);
    i++;
  }
  
  //add the merge interval
  result.add(new int[] {newStart, newEnd});
  
  //leftover intervals
  while (i < n) {
    result.add(new int[] {intervals[i][0], intervals[i][1]});
    i++;
  }
  
  //convert list to array
  int[][] merged = new int[result.size()][];
  for (int k = 0; k < result.size(); k++) merged[k] = result.get(k);
  return merged;
  
        
    }
}

