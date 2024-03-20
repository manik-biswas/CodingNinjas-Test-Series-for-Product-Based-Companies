/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution 
{
    static TreeNode < Integer> prev;
    private static TreeNode<Integer>inorderTraversal(TreeNode<Integer>root){
        if(root==null){
            return root;
        }
        TreeNode<Integer>head=inorderTraversal(root.left);
        if(prev==null){
            head = root;
        }
        else{
            prev.right=root;
            root.left=prev;
        }
        prev=root;
        inorderTraversal(root.right);
        return head;
    }
    public static TreeNode<Integer> bstToSortedDLL(TreeNode<Integer> root) {
        prev=null;
        return inorderTraversal(root);
        // Write your code here.
    }
}
