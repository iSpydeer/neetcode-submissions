class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int L = 0;
        int R = points.length - 1;
        int pivot = points.length;

        while (k != pivot) {
            pivot = partition(points, L, R);
            if (pivot < k) {
                L = pivot + 1;
            } else {
                R = pivot - 1;
            }
        }

        int[][] res = new int[k][2];
        System.arraycopy(points, 0, res, 0, k);
        return res;

    }

    private int partition(int[][] points, int s, int r) {
        int pivotDist = distanceSquared(points[r]);
        int lp = s;
        for (int i = s; i < r; i++) {
            if (distanceSquared(points[i]) <= pivotDist) {
                int[] tempPoint = points[lp];
                points[lp] = points[i];
                points[i] = tempPoint;
                lp++;
            }
        }

        int[] tempPoint = points[lp];
        points[lp] = points[r];
        points[r] = tempPoint;
        return lp;
    }

    private int distanceSquared (int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
