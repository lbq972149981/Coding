package offer;

import java.util.Arrays;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
/*
先序遍历特点：第一个值是根节点
中序遍历特点：根节点左边都是左子树，右边都是右子树

思路：

首先根据根节点a将中序遍历划分为两部分，左边为左子树，右边为右子树
在左子树中根据第一条规则递归，得出左子树
在右子树中根据第一条规则递归，得出右子树
最后合成一棵树
 */
public class reConstructBinaryTree {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) {
          val = x;
       }
    }
   public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       if(pre.length==0||in.length==0)return null;
       TreeNode root = new TreeNode(pre[0]);
       for(int i=0;i<in.length;i++){
          if(pre[0]==in[i]){
             root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
             root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
          }
       }
       return root;
   }
}
