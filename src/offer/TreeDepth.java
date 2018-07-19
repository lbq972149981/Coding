package offer;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * {1,2,3,4,5,#,6,#,#,7}
 * 4
 */
public class TreeDepth {
   public class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;

      public TreeNode(int val) {
         this.val = val;

      }
   }
   /**第一种**/
   public int TreeDepth(TreeNode root) {
      if(root==null) return 0;
      return TreeDepth(root,1);
   }
   private int TreeDepth(TreeNode node, int len) {
      int max = 0;
      int L = len;
      int R = len;
      if(node.left!=null){
         L = TreeDepth(node.left,++L);
      }
      if(node.right!=null){
         R = TreeDepth(node.right,++R);
      }
      if(node.left==null&&node.right==null){
         return len;
      }
      return L>R?L:R;
   }
   /**第二种**/
   public int TreeDepth1(TreeNode root) {
      if(root==null) return 0;
      if(root.right==null&&root.left==null)return 1;
      int left = TreeDepth(root.left);
      int right = TreeDepth(root.right);
      return left>=right?left+1:right +1;
   }
}
