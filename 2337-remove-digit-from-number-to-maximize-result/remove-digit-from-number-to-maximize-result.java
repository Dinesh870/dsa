class Solution {
    public String removeDigit(String number, char digit) {
        int n = number.length();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(number.charAt(i) == digit) list.add(i);
        }
        if(list.size() == 1) return number.substring(0,list.get(0)) + number.substring(list.get(0)+1,n);
        StringBuilder st = new StringBuilder(number);
        String ans = "";
        long max = 0;
        for(int i = 0; i < list.size(); i++) {
            String temp = number.substring(0,list.get(i)) + number.substring(list.get(i)+1,n);
            if(temp.compareTo(ans) >= 0) {
                ans = temp;
                // max = Integer.parseInt(temp);
            }
        }
        return ans;
    }
}