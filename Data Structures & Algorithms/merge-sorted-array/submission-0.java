class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m+n; i ++) {
            nums1[i] = nums2[j];
            j++;
        }
        mergeSort(nums1, 0, nums1.length - 1);
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(nums, l, m);
            mergeSort(nums, m+1, r);
            sort(nums, l, m, r);
        }
    }

    public void sort(int[] nums, int l, int m, int r) {
        int leftLength = m - l + 1;
        int rightLength = r - m;

        int[] L = new int[leftLength];
        int[] R = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            L[i] = nums[l+i];
        }

        for (int i = 0; i < rightLength; i++) {
            R[i] = nums[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < leftLength && j < rightLength) {
            if(L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            nums[k] = R[j];
            j++;
            k++;
        }

    }
}