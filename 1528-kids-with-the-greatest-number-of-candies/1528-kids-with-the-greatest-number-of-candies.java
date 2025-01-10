class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandies = 0;
        List<Boolean>trust = new ArrayList<>(); // creating an empty list for the output

        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(candies[i], maxCandies); //will store max amt from array in maxCandies variable
        }

        for (int i = 0; i < candies.length; i++) {
            trust.add(candies[i] + extraCandies >= maxCandies);
        }
        
        return trust;
    }
}