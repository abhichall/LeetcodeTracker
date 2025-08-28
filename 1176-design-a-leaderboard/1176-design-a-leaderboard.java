class Leaderboard {

    // hashmap - to store players and scores - accessible to entire class
    private Map<Integer, Integer> scores;

    public Leaderboard() {
        scores = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        //pq - by default it organizes from - reversse
        if (K == 0 || scores.isEmpty()) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        //add values into pq
        for (int score: scores.values()) pq.add(score);

        int sum = 0;
        int count = 0;

        while(!pq.isEmpty() && count < K) {
            sum = sum + pq.poll();
            count++;
        }
        return sum;
    }
    
    public void reset(int playerId) {

        //hashmap - put 0 for corresponding 
        scores.remove(playerId);
        
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */