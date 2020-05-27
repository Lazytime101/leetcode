package src.zhongxubianli_94;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {


    /**
     * 前序遍历
     * @param root
     * @return
     */
    public static List<Integer> beforeTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(root);
        while(cur!=null||!stack.empty()){
           cur = stack.pop();
           if(cur!=null){
               list.add(cur.val);
               stack.push(cur.left);
               stack.push(cur.right);
           }


        }
        return list;
    }


    public static List<Integer> beforeTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(root);
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                list.add(cur.val);
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;


        }
        return list;
    }


     /**
     * 中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null||!stack.empty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;

        }
        return list;
    }

    /**
     * 中序遍历递归
     * @param root
     * @return
     */
    public  List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal1(root,list);
        return list;
    }

    public void inorderTraversal1(TreeNode root,List<Integer> list){
        if(root==null ) return;
        inorderTraversal1(root.left,list);
        list.add(root.val);
        inorderTraversal1(root.right,list);
    }


    /**
     * 后序遍历
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        if(root == null) return list;
        stack.push(root);
        while(!stack.empty()){
            cur = stack.pop();
            list.addFirst(cur.val);
            if(cur.left!=null){
               stack.push(cur.left);
            }
            if(cur.right!=null){
                stack.push(cur.right);
            }

        }
        return list;
    }



    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode temp = treeNode;
        treeNode.left = null;
        treeNode.right= new TreeNode(2);
        temp = treeNode.right;
        temp.left = new TreeNode(3);

        List<Integer> list = postorderTraversal(treeNode);
        list.stream().forEach(a->System.out.println(a));

    }
}
