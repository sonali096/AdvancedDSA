package Tree;

public class DeserializeBinaryTree {
    public TreeNode solve(ArrayList<Integer> A) {
        if(A==null) return null;
        TreeNode root = new TreeNode(A.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(A.get(i) != -1){
                curr.left = new TreeNode(A.get(i));
                q.offer(curr.left);
            }
            i++;
            if(A.get(i) != -1){
                curr.right = new TreeNode(A.get(i));
                q.offer(curr.right);
            }
            i++;
        }
        
        return root;
    }
    
}
/*You are given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints
1 <= number of nodes <= 105

-1 <= A[i] <= 105



Input Format
Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.



Output Format
Return the root node of the Binary Tree.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Input 2:

 A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


Example Output
Output 1:

           1
         /   \
        2     3
       / \
      4   5
Output 2:

            1
          /   \
         2     3
        / \ .   \
       4   5 .   6
 */