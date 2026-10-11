class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            if (!adjList.containsKey(prerequisite[0])) {
                adjList.put(prerequisite[0], new HashSet<>());
            }

            if (!adjList.containsKey(prerequisite[1])) {
                adjList.put(prerequisite[1], new HashSet<>());
            }

            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }

        HashSet<Integer> canBeCompleted = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!canBeCompleted.contains(i)) {
                if (containsLoop(i, adjList, new HashSet<>(), canBeCompleted)) {
                    return false;
                }
            }
        }

        return canBeCompleted.size() == numCourses ? true : false;
    }

    private boolean containsLoop(int course, HashMap<Integer, HashSet<Integer>> adjList,
        HashSet<Integer> visited, HashSet<Integer> canBeCompleted) {
        if (canBeCompleted.contains(course)) {
            return false;
        }

        if (visited.contains(course)) {
            return true;
        }

        visited.add(course);
        if (adjList.containsKey(course)) {
            for (int reqCourse : adjList.get(course)) {
                if (containsLoop(reqCourse, adjList, visited, canBeCompleted)) {
                    return true;
                }
            }
        }

        canBeCompleted.add(course);
        return false;
    }
}
