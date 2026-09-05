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
        mergeSort(pairs, 0, pairs.size() -1);
        return pairs;
    }

    private void mergeSort(List<Pair> pairs, int s, int e) {
        if (e > s) {
            int m = (s+e)/2;
            mergeSort(pairs, s, m);
            mergeSort(pairs, m+1, e);
            merge(pairs, s, m, e);
        }
    }

    private void merge(List<Pair> pairs, int s, int m, int e) {
        List<Pair> L = new ArrayList<>(pairs.subList(s, m+1));
        List<Pair> R = new ArrayList<>(pairs.subList(m+1, e+1));

        int i = 0;
        int j = 0;
        int k = s;

        while (i < L.size() && j < R.size()) {
            if (L.get(i).key <= R.get(j).key) {
                pairs.set(k, L.get(i));
                i++;
            } else {
                pairs.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < L.size()) {
            pairs.set(k, L.get(i));
            i++;     
            k++;   
        }

        while (j < R.size()) {
            pairs.set(k, R.get(j));
            j++;     
            k++;   
        }

    }
}
