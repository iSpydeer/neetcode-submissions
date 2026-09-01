// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        int l = 0;
        int r = pairs.size() - 1;
        mergeSort(pairs, l, r);
        return pairs;
    }

    public void mergeSort(List<Pair> pairs, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(pairs, l, m);
            mergeSort(pairs, m + 1, r);
            merge(pairs, l, m, r);
        }
    }

    public void merge (List<Pair> pairs, int l, int m, int r) {
        System.out.println("l:" + l + ", m:" + m + ", r:" + r);
        int leftLength = m - l + 1;
        int rightLength = r - m;
        
        List<Pair> LEFT = new ArrayList<>(leftLength);
        List<Pair> RIGHT = new ArrayList<>(rightLength);

        for (int i = 0; i < leftLength; i++) {
            LEFT.add(pairs.get(l + i));
        }

        for (int i = 0; i < rightLength; i++) {
            RIGHT.add(pairs.get(m + 1 + i));
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < leftLength && j < rightLength) {
            if (LEFT.get(i).key <= RIGHT.get(j).key) {
                pairs.set(k, LEFT.get(i));
                i++;
            } else {
                pairs.set(k, RIGHT.get(j));
                j++;           
            }
            k++;
        }

        while (i < leftLength) {
            pairs.set(k, LEFT.get(i));
            i++;
            k++;
        }

        while (j < rightLength) {
            pairs.set(k, RIGHT.get(j));
            j++;
            k++;
        }
    }
}
