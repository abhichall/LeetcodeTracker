class SnapshotArray {

    //hmap to store index and than a running int pair of snapID, and updated value
    Map<Integer, List<int[]>> snapshots;
    
    //counter to keep track of snap id consitently throughout all methods
    int snapID;

    public SnapshotArray(int length) { //length isnt necesarry - unoptimal
        snapshots = new HashMap<>();
        snapID = 0;
    }
    
    //care about latest snapshot
    public void set(int index, int val) {

        //count for current freq list
        snapshots.putIfAbsent(index, new ArrayList<>());
        List<int[]> history = snapshots.get(index);

        //need to check if we have to add snapid or update same existing snapid

        if (!history.isEmpty() && history.get(history.size() - 1)[0] == snapID) { //checking to see if this is under the same snap id   
            history.get(history.size() - 1)[1] = val;
        } else {
            history.add(new int[] {snapID, val});
        }
        
    }
    
    public int snap() {
        //only want to increment it (whenever it is called)
        return snapID++;
    }
    
    public int get(int index, int snap_id) {
        //since the snapID is already sorted, at each index it goes from lowest to highest
        //could iterate through each index list to get the latest one but thats 0(n)

        //binary search because already sorted within the array

        //get the specific list based on index 
        List<int[]> history = snapshots.get(index);

        //edge case
        if (history == null) return 0; // never set → default 0
            
        //binary search
        int left = 0;
        int right = history.size() - 1;
        int res = 0; 
            
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (history.get(mid)[0] <= snap_id) {
                res = history.get(mid)[1]; 
                left = mid + 1;            
            } else {
                right = mid - 1;           
            }
        }
            
        return res;
    }
}


/**
first idea is just an array 
so since we have the snap method, and we need to keep track of each creation.

if we used a hashmap for SNAP
    
    we could have each index have a list of pairs where -- [snapID, newValue]
    so when we then get -- we get the index and then we can look for the relative snapID
        since the snapID will be in ascneidng order, Binary search would be most optimal 

 */








/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */