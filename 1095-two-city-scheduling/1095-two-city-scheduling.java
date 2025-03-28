class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
     Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1])); //will compute differences and sort by that -- neg - post

        int totalCost = 0;
        int ppl = costs.length/2;

        //iterate thru array, and find 'cutoff' for first n ppl
        for(int i = 0; i < ppl; i++) {
            totalCost += costs[i][0];
        }

        //account for ppl to coty b
        for(int i = ppl; i < 2*ppl; i++) {
            totalCost += costs[i][1];
        }

        return totalCost;
    }

}

