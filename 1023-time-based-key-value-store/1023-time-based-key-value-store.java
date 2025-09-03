class TimeMap {

    final Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        this.store = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        
        //make sure that each key has a treemap, if not that create one
        TreeMap<Integer, String> innerMap = store.computeIfAbsent(key, k -> new TreeMap<>());

        //set at that pertaining value
        innerMap.put(timestamp, value);

    }
    
    public String get(String key, int timestamp) {

        //tree map sorts in ascneding --  keys -> least to greatest
        TreeMap<Integer, String> innerMapT = store.get(key);

        if(innerMapT == null) {
            return "";
        }

       //the greatest key value <= timestamp
       Map.Entry<Integer, String> pair = innerMapT.floorEntry(timestamp);  // gives result that is <= whats passed in

       if( pair == null) {
        return "";
       }

       return pair.getValue(); //greatest timestamp that is less or equal to current timestamp
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */


 /**
 
 FUNCTION:
    store multiple values for the same key at different timestamps
    retrieve a key's value at specific timestamps


 
 Input
        ["TimeMap", "set", "get", "get", "set", "get", "get"]
 
        [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]

Output
        [null, null, "bar", "bar", null, "bar2", "bar2"]


question is aksing us, to retrive the closest timestamp <= current timestamp
 


IDEAS
    have a pair at each value and store the value with key, iterate to get largest timestamp -- o (n)


    
    max-heap, treemap

    Hashmap, to store <String, TreeMap<Integer, String>
    
    if it already exists, treemap will override that value

    SET
        if key is already present, put the new value at that timestamp
        if not, create new treemap at that specific key

    GET
        return the value for key that, with its largest timestamp <= given timestamp
        check null
        .floorEntry - greatest key 

  */