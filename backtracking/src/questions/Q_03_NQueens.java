package questions;

// Place n queens in a n*n matrix
// Queen can attack vertically, horizontally and diagonally.
public class Q_03_NQueens {
    public static void placeQueens(int[][] chess, int row) {
        if(row>=chess.length){
            // Placed
            for(int i=0;i<chess.length;i++){
                for (int j=0;j<chess[0].length;j++){
                    System.out.print(chess[i][j]+" ");
                }
            }
            System.out.println();
            return;
        }

        int[] entireRow = chess[row];
        for(int col=0;col<entireRow.length;col++){
            boolean isContinue = false;
            for(int j=0;j<chess.length;j++){
                for(int k=0;k<chess[j].length;k++){
                    if(j==row || k==col || j==k || j+k==row+col || (k-j)==(col-row)){
                        if(chess[j][k]==1){
                            isContinue=true;
                        }
                    }
                }
            }
            if(isContinue){
                continue;
            }
            entireRow[col] = 1;
            placeQueens(chess,row+1);
            entireRow[col] = 0;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] chess = new int[n][n];
        placeQueens(chess,0);
    }

}
