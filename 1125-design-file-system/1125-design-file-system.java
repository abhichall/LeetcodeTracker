class FileSystem {

    private final Map<String, Integer> pathMap;

    public FileSystem() {
        pathMap = new HashMap<>();
        pathMap.put("", -1);
        
    }
    
    public boolean createPath(String path, int value) {
        if(pathMap.containsKey(path)) return false;

        int lastSlash = path.lastIndexOf('/');
        if(lastSlash == -1) return false;


            

        String parent = path.substring(0, lastSlash);

        if (!pathMap.containsKey(parent)) return false; 

        pathMap.put(path, value);
        return true;
    }   

    public int get(String path) {
        return pathMap.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */