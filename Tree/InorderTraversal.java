package Tree;
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class InorderTraversal {
    ArrayList<Integer> ans = new ArrayList<>();
    public int[] inorderTraversal(TreeNode A) {
        solve(A);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public void solve(TreeNode A){
        if(A==null){
            return;
        }
        solve(A.left);
        ans.add(A.val);
        solve(A.right);
    }
}
/*Given a binary tree, return the inorder traversal of its nodes' values.
 * Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the inorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]
 */