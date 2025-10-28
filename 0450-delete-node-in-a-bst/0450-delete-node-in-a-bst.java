class Solution {

      public static TreeNode Inorderpredecessor(TreeNode root){
            TreeNode temp = root.left;
            while (temp.right != null) temp = temp.right;
            return temp;
      }

      public static TreeNode parent(TreeNode root, TreeNode pred){
            TreeNode temp = root.left;
            while (temp != null && temp.right != pred) temp = temp.right;
            return temp;
      }

      public TreeNode deleteNode(TreeNode root, int key){ // ✅ function name fixed

            if(root == null) return null;

            if(root.val == key){ //delection(There are a 3 case in this term ok) case 1
                  
                  if(root.left == null && root.right == null){
                        return null;
                  }

                  //case 2 
                  else if(root.left == null || root.right == null){
                        if(root.left == null) return root.right;
                        else return root.left;
                  }

                  //case 3  to isame hamko root TreeNode delete karna hai to hamko to hamko ye karna hogga ke root jo bhi hata raeh hai us se ek chhota jo usko lga de or sara kaam ho jayega 2 tarike hai karne ke {replce key TreeNode with inorder predecessor}
                  else{
                        TreeNode pred = Inorderpredecessor(root);
                        
                        // agar pred root ke left child me hai to direct replace kar do
                        if (pred == root.left) {
                              pred.right = root.right;
                              return pred;
                        }

                        TreeNode predParent = parent(root, pred);

                        // predParent.right ko pred ke left se attach karo (taaki pred delete ho jaye logically)
                        if (predParent != null) {
                              predParent.right = pred.left;
                        }

                        // ab pred ko root ki jagah set karo
                        pred.left = root.left; 
                        pred.right = root.right;
                        return pred;
                  }

            } else if(root.val > key){ //LCS well chnage 
                  root.left = deleteNode(root.left, key);
            } else { // RST well chnage 
                  root.right = deleteNode(root.right, key);
            }
            return root;
      }
}
