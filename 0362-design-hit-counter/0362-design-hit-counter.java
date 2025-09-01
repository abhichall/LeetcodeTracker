class HitCounter {

    //its a fixed side of ds that we need so should be o1

    int[] times;
    int[] hits;

    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }
    
    public void hit(int timestamp) {

        //map timestamp to index in array - last 5 min only
        int index = timestamp % 300;

        //check for outdated info
        if(times[index] != timestamp) {
            times[index] = timestamp;       //set to current timestamp and then at related add hit count++
            hits[index] = 1; 
        } else {
            hits[index]++;
        }


        
    }
    
    public int getHits(int timestamp) {
        
        int total = 0;

        for(int i = 0; i < 300; i++) {

            if(timestamp - times[i] < 300) {
                total = total + hits[i];
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
 
 make two arrays of size 300 -- one to trackt timestamp for an index and other to track hit amount at same index (300 represents last 5 minutes)
 use modolus to get index/duplicate values and use it to update in timestamp metric
 

 
  */