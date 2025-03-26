class RandomizedSet {

Set<Integer> hset = new HashSet<>();
   
    
    public boolean insert(int val) {
        boolean cond = hset.contains(val);

        if (cond == true) {
            return false;
        } else {
            hset.add(val);
          return true;
        }
        
    }
    
    public boolean remove(int val) {
         boolean cond = hset.contains(val);

         if(cond == true) hset.remove(val);
         return cond;
    }
    
    public int getRandom() {
         // convert HashSet to an array 
        Integer[] arrayNumbers = hset.toArray(new Integer[hset.size()]); 
  
        // generate a random number 
        Random rndm = new Random(); 
  
        // this will generate a random number between 0 and 
        // HashSet.size - 1 
        int rndmNumber = rndm.nextInt(hset.size());
        
        return arrayNumbers[rndmNumber];        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */