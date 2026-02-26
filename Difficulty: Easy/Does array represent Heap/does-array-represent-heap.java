class Solution {

    public boolean countSub(long arr[], long n) {

        for (int i = 0; i < n; i++) {

            int lc = 2 * i + 1;
            int rc = 2 * i + 2;

            if (lc < n && arr[i] < arr[lc]) {
                return false;
            }

            if (rc < n && arr[i] < arr[rc]) {
                return false;
            }
        }

        return true;
    }
}