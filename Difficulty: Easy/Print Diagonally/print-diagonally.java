class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        int n = mat.length;
        ArrayList<Integer> antiDiagonals = new ArrayList<>();
        
        for(int col = 0; col < n; col++) {
            int i = 0, j = col;
            while(i < n && j >= 0) {
                antiDiagonals.add(mat[i][j]);
                i++;
                j--;
            }
        }
        
        for(int row = 1; row < n; row++) {
            int i = row, j = n - 1;
            while(i < n && j >= 0) {
                antiDiagonals.add(mat[i][j]);
                i++;
                j--;
            }
        }
        
        return antiDiagonals;
    }
}