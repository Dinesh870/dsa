class Solution {
    public String removeDigit(String number, char digit) {
        int n = number.length();
        ArrayList<Integer> list = new ArrayList<>();
        // StringBuilder st = new StringBuilder(number);
        String ans = "";

        for(int i = 0; i < n; i++) {
            if(number.charAt(i) == digit) {
                list.add(i);
                String temp = number.substring(0,i) + number.substring(i+1,n);
                if(temp.compareTo(ans) >= 0) {
                    ans = temp;
                }
            }
        }
        
        // for(int i = 0; i < list.size(); i++) {
        //     String temp = number.substring(0,list.get(i)) + number.substring(list.get(i)+1,n);
        //     if(temp.compareTo(ans) >= 0) {
        //         ans = temp;
        //     }
        // }
        return ans;
    }
}