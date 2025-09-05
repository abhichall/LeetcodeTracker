class HitCounter {

    //initialize window size
    int window = 300;

    //arrrays to hold time and hits
    int[] times = new int[300];
    int[] hits = new int[300];

    public HitCounter() {

        this.times = new int[window];
        this.hits = new int[window];
    }
    
    public void hit(int timestamp) {

        //find the index of this timestamp
        int index = timestamp % 300;

        //is this given timestamp a new value, or is it already there
        if(times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++; //the timestamp is within range, so we just iterate the hit value
        }
    }
    
    public int getHits(int timestamp) {

        //return the number of hits WITHIN the past 5 minutes

        int total = 0; //to store the total as we iterate

        for(int i = 0; i < window; i++) {
            
            if (timestamp - times[i] < window) {
                 total += hits[i];
            }
        }
        return total;
        
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

 /**
 
 
 DS that counts number of hits received in the past 300 seconds
 calls are made chronologically -- POSSIBLE for multiple hits to be at the same time

we only care about that last 300 seconds

    4 ...... 300 301 302 303

only care about the first 5 seconds
    [1 2 3 4 5 6]
if we use an array, only carin about the first 300 seconds

    1 % 300 -- first index of the array
    2 % 300 -- second index of the array
    300%300 -- 0 nindex
    301 % 300 - 1 have a new value/reference-

    create 2 arrays
        times - at index i = time of hit
        hits - at time i, the val stored in array will be the # of hits 

        [1 2 3 4 5]
    `   [1 3 4 5 6] 
 
 
 
  */