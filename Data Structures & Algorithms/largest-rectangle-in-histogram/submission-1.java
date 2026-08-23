class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer[]> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int curHeight = heights[i];
            int curIndex = i;

            //pop bars that cannot stretch
            while (!stack.isEmpty() && stack.peek()[1] >= curHeight) {
                Integer[] tempBar = stack.pop();
                int tempArea = tempBar[1] * (i - tempBar[0]);
                if (tempArea > maxArea) {
                    maxArea = tempArea;
                }
                curIndex = tempBar[0];
            }

            //push new bar
            stack.push(new Integer[]{curIndex, curHeight});
        }

        //calculate what's left in the stack
        while (!stack.isEmpty()) {
            Integer[] tempBar = stack.pop();
            int tempArea = tempBar[1] * (heights.length - tempBar[0]);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }
        }

        return maxArea;
    }
}
