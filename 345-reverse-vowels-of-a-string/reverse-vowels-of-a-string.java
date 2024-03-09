class Solution {
    public String reverseVowels(String s) {
        int p = 0, q = s.length()-1;
        char[] charArr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        while(p < q) {
            if(set.contains(charArr[p]) && set.contains(charArr[q])) {
                char t = charArr[p];
                charArr[p] = charArr[q];
                charArr[q] = t;
                p++;
                q--;
            }else if(!set.contains(charArr[p])) p++;
            else q--;
        }
        return new String(charArr);
    }
}