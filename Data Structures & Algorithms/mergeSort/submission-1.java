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
        mergeSort(pairs, 0, pairs.size()-1);
        return pairs;
    }

    public void mergeSort(List<Pair> pairs, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(pairs, l, m);
            mergeSort(pairs, m+1, r);
            merge(pairs, l, m, r);
        }
    }

    public void merge(List<Pair> pairs, int l, int m, int r) {
        List<Pair> LEFT = new ArrayList<>(pairs.subList(l, m+1));
        List<Pair> RIGHT = new ArrayList<>(pairs.subList(m+1, r+1));

        int i = 0;
        int j = 0;
        int k = l;

        while (i < LEFT.size() && j < RIGHT.size()) {
            if (LEFT.get(i).key <= RIGHT.get(j).key) {
                pairs.set(k, LEFT.get(i));
                i++;
            } else {
                pairs.set(k, RIGHT.get(j));
                j++;
            }
            k++;
        }

        while (i < LEFT.size()) {
            pairs.set(k, LEFT.get(i));
            i++;
            k++;
        }

        while (j < RIGHT.size()) {
            pairs.set(k, RIGHT.get(j));
            j++;
            k++;
        }
    }
}
