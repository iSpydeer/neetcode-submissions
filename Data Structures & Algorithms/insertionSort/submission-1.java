// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> retList = new ArrayList<>();
        int n = pairs.size();
        if (pairs.size() == 0) {
            return retList; 
        }

        retList.add(new ArrayList<>(pairs));
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j-1 >= 0 && pairs.get(j-1).key > pairs.get(j).key) {
                Pair temp = pairs.get(j-1);
                pairs.set(j-1, pairs.get(j));
                pairs.set(j, temp);
                j--;
            }
            retList.add(new ArrayList<>(pairs));
        }
        return retList;
    }
}
