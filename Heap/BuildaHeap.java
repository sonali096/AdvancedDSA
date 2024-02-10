package Heap;

import java.util.*;
class Solution {
    ArrayList<Integer> ans=new ArrayList<>();
    // create dynamic array to insert element at every go
    public int[] buildHeap(int[] A) {
        for(int i=0;i<A.length;i++){
            insert(A[i]);
        }
        int Arr[]=new int[ans.size()];//convert arraylist into return array
        for(int i=0;i<Arr.length;i++){
            Arr[i]=ans.get(i);
        }
        return Arr;
    }
    public void insert(int val){
        ans.add(val);
        int i=ans.size()-1;
        while(i>0){
            int p=(i-1)/2;
            if(ans.get(p)>ans.get(i)) {
                swap(p,i);
                i=p;
            }else break;
        }
    }
    public void swap(int i,int j){
        int t=ans.get(i);
        ans.set(i,ans.get(j));
        ans.set(j,t);
    }
}

public class Build a Heap {
    

/*Build Min Heap
Concept:
Heap is structurally a complete binary tree and logically nodes are present in the array. 
In this problem in the given array represents the nodes of complete binary tree (CBT) that will form a min heap.
Min heap is such complete binary tree (CBT) where value of parent node is smaller than its children. 
Now in the problem the given array, if we observe the node value then we can see the array elements are not stored in min heap order.
In array if a node present at ith index then the left child of this node is present at 2*i+1 index and the right child is present at 2*I + 2.


Solution Approach:

1.       We can imaginary think that A[0] is already in heap and every time we shall add one element at a time at heap and compare the children with parent and swap the smallest value. This way we can build a min heap.

Time Complexity: O(N) * O(logN) ~ O(NlogN)
Space Complexity: O(1)

2.       We can observe an array as complete binary tree. In CBT we can say that leaf nodes are already in min heap. Now from second last level we should perform heapify to make the subtree as min heap. In similar fashion we shall traverse all the nodes up till root of the tree and make them min heap with the help of heapify. Finally our main tree will become min heap.

Time Complexity: O(N)
Space Complexity: O(1)

 Code </>*/
public int[] buildHeap(int[] A) {
        // code here
        // we start from parent of last child and perform heapify to make the subtree as min heap.
        // Min Heap: parent node is smaller than children.
        // TC: O(N) SC: O(1)
        int N = A.length;
        for(int i=(N-2)/2; i>=0; i--){
            heapify(A,i);
        }
        return A;
    }
    // helper method to make a subtree as min Heap,
    // The root of the SubTree will be present at ith index in the array
    private void heapify(int[] arr, int i){
        int N = arr.length;
        int leftChild = arr[2*i+1];
        int rightChild = 2*i+2<N? arr[2*i+2]:-1;
        
        while(i < N){
            int minChild = Math.min(leftChild,rightChild);
            int min = Math.min(minChild,arr[i]);

            if(min == leftChild){
                //swap left with arr[i]
                int temp = arr[i];
                arr[i] = leftChild;
                leftChild = temp;

                i = 2*i + 1;
            }
            else if(min == rightChild){
                // swap right child with arr[i]
                int temp = arr[i];
                arr[i] = rightChild;
                rightChild = temp;

                i = 2*i+2;
            }
            else{
                break;
            }
        }
    }
}