class Solution {
    // ArrayList<Integer> findSquare(ArrayList<Integer> list) {
    //     for(int i = 0; i < list.size(); i++) {
    //         int p = list.get(i);
    //         p *= p;
    //         list.set(i,p);
    //     }
    //     // System.out.println(list);
    //     return list;
    // }
    public int[] sortedSquares(int[] nums) {
        // ArrayList<Integer> pos = new ArrayList<>();
        // ArrayList<Integer> neg = new ArrayList<>();
        // int n = nums.length;
        // int p = 0;
        // // seperate positive and negative element
        // while(p < n) {
        //     if(nums[p] >= 0) {
        //         pos.add(nums[p]);
        //     }else{
        //         neg.add(nums[p]);
        //     }
        //     p++;
        // }
        // int i = 0, j = neg.size()-1;
        // while(i <= j) {
        //     Integer q = neg.get(i);
        //     neg.set(i,neg.get(j));
        //     neg.set(j,q);
        //     i++;
        //     j--;
        // }
        // pos = findSquare(pos);
        // // System.out.println(pos);
        // neg = findSquare(neg);
        // // System.out.println(neg);
        // i = 0;
        // j = 0;
        // int k = 0;
        // while(i < pos.size() && j < neg.size()) {
        //     if(pos.get(i) < neg.get(j)) {
        //         nums[k] = pos.get(i);
        //         i++;
        //     }else {
        //         nums[k] = neg.get(j);
        //         j++;
        //     }
        //     k++;
        // }
        // while(i < pos.size()) {
        //     nums[k++] = pos.get(i);
        //     i++;
        // }
        // while(j < neg.size()) {
        //     nums[k++] = neg.get(j);
        //     j++;
        // }

        // return nums;

        // method 2:
        // for(int i = 0; i < nums.length; i++) {
        //     nums[i] *= nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;

        // method 3:
        int k = nums.length-1;
        int curr = 0;
        int[] ans = new int[k+1];
        int p = 0, q = k;
        while(p<=q) {
            if(Math.abs(nums[p]) < Math.abs(nums[q])){
                curr = nums[q];
                q--;
            }else {
                curr = nums[p];
                p++;
            }
            ans[k] = curr*curr;
            k--;
        }
        return ans;
    }
}
