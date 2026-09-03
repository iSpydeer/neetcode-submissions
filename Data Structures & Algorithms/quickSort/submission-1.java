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

    public void quickSort(List<Pair> pairs, int s, int e) {
        if (e - s <= 0) {
            return;
        }

        int lp = s;
        Pair pivot = pairs.get(e);

        for (int i = s; i < e; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(lp);
                pairs.set(lp, pairs.get(i));
                pairs.set(i, temp);
                lp++;
            }
        }

        pairs.set(e, pairs.get(lp));
        pairs.set(lp, pivot);

        quickSort(pairs, s, lp-1);
        quickSort(pairs, lp+1, e);
    }
}
