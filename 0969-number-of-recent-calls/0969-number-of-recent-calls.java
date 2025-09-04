class RecentCounter {

    Deque<Integer> pingCount;

    public RecentCounter() {
        this.pingCount = new ArrayDeque<>();
    }
    
    public int ping(int t) {

        //Add the new timestamp
        pingCount.addLast(t);

        //have a var to hold reference to the last 3000 milliseconds since t
        int pastPings = t - 3000;

        //make sure the deque now only hold values from t - 3000 to t
        while(!pingCount.isEmpty() && pingCount.peekFirst() < pastPings) {
            pingCount.removeFirst();
        }

        //at this point the deque ONLY contains values in the desired range
        return pingCount.size();
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */


 /**
 
 RecentCounter() - initialize counter with 0 requests

 int ping(int t) - t is some time; add a new req at t milliseconds & return # of requests that happened in last 3000 milliseconds and current -- [t - 3000, t] -- NUMBER OF 

 EVERY CALL OF PING, PASSES THROUGH A STRICTLY LARGER VALLUE OF T THAN PREV CALL

 want a way to add new times to the end of a DS so, when ping is called we can add to end, and then return [t -3000, t]

 DEQUE data strucute

    when ping is called
        we can add it to the end of the deque
        remove any values OLDER than t - 3000 - removeFirst

        return the deque size since it only contains t-3000 to t 

    
 
 
 
 
  */