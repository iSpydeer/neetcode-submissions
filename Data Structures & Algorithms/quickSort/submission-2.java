// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSort(pairs, 0, pairs.size()-1);
        return pairs;
    }

    private void quickSort(List<Pair> pairs, int s, int e) {
        if (e-s <= 0) {
            return;
        }

        int idx = s;
        Pair pivot = pairs.get(e);

        for (int i = s; i < e; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(idx);
                pairs.set(idx, pairs.get(i));
                pairs.set(i, temp);
                idx++;
            }
        }

        pairs.set(e, pairs.get(idx));
        pairs.set(idx, pivot);

        quickSort(pairs, s, idx - 1);
        quickSort(pairs, idx+1, e);
    }
}
