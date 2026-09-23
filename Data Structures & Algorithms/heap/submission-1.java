class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<Integer>();
        this.heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        percolateUp(heap.size() - 1);
    }

    public Integer pop() {
        if (heap.size() <= 1) {
            return -1;
        }

        if (heap.size() == 2) {
            return heap.remove(1);
        }

        int res = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));
        percolateDown(1);
        return res;
    }

    public Integer top() {
        if (heap.size() <= 1) {
            return -1;
        } else {
            return heap.get(1);
        }
    }

    public void heapify(List<Integer> nums) {
        heap = new ArrayList<>();
        heap.add(0);
        heap.addAll(nums);

        int cur = (heap.size() - 1) / 2;
        while (cur > 0) {
            percolateDown(cur);
            cur--;
        }
    }

    private void swap(int a, int b) {
        int temp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    private void percolateUp(int i) {
        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    private void percolateDown(int i) {
        while (2 * i < heap.size()) {
            if (2 * i + 1 < heap.size() && heap.get(2 * i + 1) < heap.get(2 * i)
                && heap.get(i) > heap.get(2 * i + 1)) {
                swap(i, 2 * i + 1);
                i = 2 * i + 1;
            } else if (heap.get(i) > heap.get(2 * i)) {
                swap(i, 2 * i);
                i = 2 * i;
            } else {
                break;
            }
        }
    }
}
