package src.SameTree_100;

import helper.TreeNode;

public class Solution {


        //递归方法，每次只用判断val节点，递归调用即可
        //注意判空情况
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null&&q==null)
                return true;
            if (q == null || p == null) return false;
            if(p.val!=q.val){
                return false;
            }
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }

}
