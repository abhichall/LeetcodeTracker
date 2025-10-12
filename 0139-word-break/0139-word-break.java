class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        //edge case
        if (s == null) return false;

        //hashset - to store the stuff  in hashset
        Set<String> hset = new HashSet<>(wordDict);

        int n = s.length();

        //dp[i] = true -- at substring (0,i), this can be segmented into dictionary words
        boolean[] dp = new boolean[n+1];
        dp[0] = true; //empty string is possible technically

        //keep track of longest word -- cant be more so we can immediately cancel those out
        int maxLength = 0;
        for(String w : wordDict) maxLength = Math.max(maxLength, w.length());

        for (int i = 1; i <= n; i++) {

            int start = Math.max(0, i - maxLength);

            for (int j = start; j < i; j++) {
                
                if(!dp[j]) continue; 

                String check = s.substring(j, i);
                if(hset.contains(check)) {
                    dp[i] = true;
                    break;
                }
            }


        }
return dp[n];

    }
}

/**


can be any order? no

IDEAS
find every subset and store in hashmap -- 2^n not efficient at all

dp
boolean arrray
dp[i] -- until s[0, i] it is possible and j keep building off of one more?

for each index
check the prev position and if its true and the substring till curr i is in dict, then also true

 */