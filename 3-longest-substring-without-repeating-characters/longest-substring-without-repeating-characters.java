class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet<Character> set = new HashSet<>();
        // int ans = 0;
        // for(int i = 0; i < s.length(); i++) {
        //     boolean flag = true;
        //    for(int j = i; j < s.length(); j++) {
        //        char c = s.charAt(j);
        //        if(set.contains(c)) {
        //            flag = false;
        //            break;
        //        }else {
        //            set.add(c);
        //        }
        //    }
        //     if(!flag) {
        //         ans = Math.max(ans,set.size());
        //         set.clear();
        //     }else {
        //         ans = Math.max(ans,set.size());
        //     }
           
        // }
        // return ans;


        // method 2:
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int ans = 0;
        for(int right=0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(!set.contains(c)) {
                set.add(c);
                ans = Math.max(set.size(),ans);
            }else {
                while(s.charAt(left) != c) {
                    set.remove(s.charAt(left));
                    left++;
                }
                // set.remove(s.charAt(left));
                left++;
                set.add(c);
                // ans = Math.max(ans,set.size());
            }
        }
        return ans;
    }
}