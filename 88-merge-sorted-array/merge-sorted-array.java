class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // int l = m + n;
        // if(l == nums1.length) return;
        // int arr[] = new int[l];
        // arr = nums1;
        // int i = 0;
        // int j = 0;
        // System.out.print(nums1.length);
        // for(int i = m; i < l; i++)
        // {
        //     arr[i] = nums2[j];
        //     j++;
        // }
        // Arrays.sort(arr);

        // for(int i = 0; i < l ;i++)
        // {
        //     if(num1[i] != '\0')
        //     {
        //       if(num1[i] < num2[j])
        //       {
        //           continue;
        //       }
        //       else
        //       {
        //           arr[i] = num2[j];
        //           j++;
        //       }
        //     }
        //     else{
        //         arr = num2;
        //     }
        // }

        int last = m;
        if(n == 0) return;

        int j = m-1;
        int i = n-1;
        int l = m + n;

        while(j >= 0 && i >= 0) {
            if(nums1[j] > nums2[i]) {
                nums1[l-1] = nums1[j];
                j--;
                l--;
            } else {
                nums1[l-1] = nums2[i];
                i--;
                l--;
            }
        }
        if(i < 0) return;
        while(i >= 0) {
            nums1[l-1] = nums2[i];
            i--;
            l--;
        }
    }
}