package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

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
class Node{
    TreeNode node;
    int vericalCol;
    Node{TreeNode node, int vericalCol}{
        this.node = node;
        this.vericalCol = vericalCol;
    }
    TreeNode getNode(){
        return this.node;
    }
    int getverticalCol(){
        return this.vericalCol;
    }
}
public class Verticalordertraversal {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A,0));
        while(!q.isEmpty()){
            Node node = q.remove();
            TreeNode x = node.getNode();
            int verticalCol = node.getverticalCol();
            if(x.left != null){
                q.add(new Node(x.left, verticalCol-1));
            }
            if(x.right!=null){
                q.add(new Node(x.right, verticalCol+1));
            }
            addToHashMap(hm,x,verticalCol);
        }
        Set<Integer> keys = hm.keySet();
        int minIndex=Integer.MAX_VALUE;
        int maxIndex=Integer.MIN_VALUE;
        for(Integer key: keys){
            if(minIndex>key) minIndex = key.intValue();
            if(maxIndex<key) maxIndex=key.intValue();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=minIndex;i<=maxIndex;i++){
            list.add(hm.get(i));
        }

        return list;
    }
    private void addToHashMap(HashMap<Integer,ArrayList<Integer>> hm,TreeNode tn, int index){
        ArrayList<Integer> list;
        if(hm.containsKey(index)){
            list = hm.get(index);
        }else{
            list = new ArrayList<>();
        }
        list.add(tn.val);
        hm.put(index, list);

    }

    
}
/*Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
0 <= number of nodes <= 105



Input Format
First and only arument is a pointer to the root node of binary tree, A.



Output Format
Return a 2D array denoting the vertical order traversal of tree as shown.



Example Input
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Input 2:

      1
    /   \
   3     7
  /       \
 2         9


Example Output
Output 1:

 [
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
Output 2:

 [
    [2],
    [3],
    [1],
    [7],
    [9]
 ]


Example Explanation
Explanation 1:

 First row represent the verical line 1 and so on.
 */