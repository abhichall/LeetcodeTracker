class StockPrice {

    final Map<Integer, Integer> timeToPrice; ////timestamp - current price
    final PriorityQueue<int[]> max; //max heap by price,timestamp -- storing both to check for stale later
    final PriorityQueue<int[]> min; // min heap by price,timestamp -- storing both to check for stale later
    int latest;

    public StockPrice() {
        this.timeToPrice = new HashMap<>();
        this.max = new PriorityQueue<int[]>((a,b) -> Integer.compare(b[0], a[0]));
        this.min = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        this.latest = 0;
    }
        
    
    
    public void update(int timestamp, int price) {

        //update altest timestamp
        if (timestamp > latest) latest = timestamp;

        timeToPrice.put(timestamp, price); //update map w current price

        //push into both heaps
        max.offer(new int[] {price, timestamp});
        min.offer(new int[] {price, timestamp});
    }
    
    public int current() {
        return timeToPrice.get(latest);
        
    }
    
    public int maximum() {

        //need to check to mak sure it matfches timestamp and current price
        while(!max.isEmpty()) {
            int[] top = max.peek(); // takes out [price, timestamp]
            int price = top[0];
            int timestamp = top[1];
            int currentPrice = timeToPrice.getOrDefault(timestamp, -999);

            if (currentPrice == price) return price;

            //else it is a old/wrong amount so remove
            max.poll();
        }
        //should never reach here
        return -1;
    }
    
    public int minimum() {
        
        while (!min.isEmpty()) {
        int[] top = min.peek(); // takes out [price, timestamp]
            int price = top[0];
            int timestamp = top[1];
            int currentPrice = timeToPrice.getOrDefault(timestamp, -999);

            if (currentPrice == price) return price;

            //else it is a old/wrong amount so remove
            min.poll();
        }
    
    return -1;
}}



/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */