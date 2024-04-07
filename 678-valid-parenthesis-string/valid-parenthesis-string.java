class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openBracket = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='(') openBracket.push(i);
            else if(ch=='*') stars.push(i);
            else {
                if(!openBracket.isEmpty()) {
                    openBracket.pop();
                } else if(!stars.isEmpty()) {
                    stars.pop();
                } else {
                    return false;
                }
            }
        }
        while(!openBracket.isEmpty() && !stars.isEmpty()) {
            if(openBracket.pop() > stars.pop()) return false;
        }
        if(openBracket.isEmpty()) return true;

        return false; 
    }
}