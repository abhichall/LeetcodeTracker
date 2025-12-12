class Solution {
    public String simplifyPath(String path) {

        if (path == null || path.length() == 0) {
            return "/";
        }

     //split on /
     String[] parts = path.split("/");

     Deque<String> stack = new ArrayDeque<>();

     for (String s: parts) {
        if(s.length() == 0 || s.equals(".")) {
            continue;
        }

        if (s.equals("..")) {
            if (!stack.isEmpty()) {
                stack.removeLast();
            }
        } else {
            stack.addLast(s);
        }
     }

     if(stack.isEmpty()) {
        return "/";
     }

     StringBuilder sb = new StringBuilder();

     for(String d:stack) {
        sb.append('/');
        sb.append(d);
     }
return sb.toString();
    }
}

/**

use a stack to look at each item




 */