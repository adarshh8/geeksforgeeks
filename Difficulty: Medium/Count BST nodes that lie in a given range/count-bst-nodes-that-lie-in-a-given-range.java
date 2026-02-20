class Solution {
    int check(Node root, int l, int h){
        if(root == null){
            return 0;
        }
        if(root.data >= l && root.data <= h){
            return 1 + check(root.right,l,h) + check(root.left,l,h);
        }
        else if(root.data < l){
            return check(root.right,l,h);
        }
        else{
            return check(root.left,l,h);
        }
    }

    int getCount(Node root, int l, int h) {
        return check(root,l,h);
    }
}