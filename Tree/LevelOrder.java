package Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }
}

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        // Base case: Return empty list if root is null
        if (A == null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(A.val);
        ans.add(first);

        while (!q.isEmpty()) {

            // Current level list
            ArrayList<Integer> level = new ArrayList<Integer>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();

                // Add current node value to level list
                level.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            ans.add(level);
        }

        // Remove the first level (root node only)
        ans.remove(0);
        return ans;
    }
    
}
/*Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return a 2D integer array denoting the level order traversal of the given binary tree.



Example Input
Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [
   [3],
   [9, 20],
   [15, 7]
 ]
Output 2:

 [ 
   [1]
   [6, 2]
   [3]
 ] */