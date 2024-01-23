package Tree;

import java.util.ArrayList;
import java.util.Queue;

import LL.LinkedList;

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
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode last = A;
        if(A==null){
            return ans;
        }
        q.add(A);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode f = q.peek();
                q.remove();
                list.add(f.val);
                if(f.left!=null){
                    q.add(f.left);
                }
                if(f.right != null){
                    q.add(f.right);
                }
            }
            ans.add(list);
        }
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