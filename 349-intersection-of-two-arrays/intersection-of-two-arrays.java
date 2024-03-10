class Solution {
    boolean search(int[] arr, int k) {
        int i = 0, j= arr.length-1;
        while(i <= j) {
            int mid = (i+j)/2;
            if(arr[mid] == k) return true;
            else if(k > arr[mid]) i = mid+1;
            else j = mid-1;
        }
        return false;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set<Integer> set1 = new HashSet<>();
        // Set<Integer> set2 = new HashSet<>();
        // Set<Integer> set3 = new HashSet<>();

        // for(int i : nums1) set1.add(i);
        // for(int i : nums2) set2.add(i);
        
        // for(var i : set1) {
        //     if(set2.contains(i)) set3.add(i);
        // }
        // int[] ans = new int[set3.size()];
        // int k = 0;
        // for(var i : set3) ans[k++] = i;
        // return ans;

        // method 2:
        
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // Set<Integer> set = new HashSet<>();

        // int i = 0, j = 0;
        // while(i < nums1.length && j < nums2.length) {
        //     if(nums1[i] == nums2[j]) {
        //         set.add(nums1[i]);
        //         i++;
        //         j++;
        //     }else if(nums1[i] > nums2[j]) j++;
        //     else i++;
        // }        
        // int[] ans = new int[set.size()];
        // int k = 0;
        // for(var v : set) {
        //     ans[k++] = v;
        // }
        // return ans;

        // method 3:

        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums2.length; i++) {
            if(search(nums1, nums2[i])) set.add(nums2[i]);
        }
        int[] ans = new int[set.size()];
        int k = 0;
        for(var v : set) {
            ans[k++] = v;
        }
        return ans;
        
    }
}