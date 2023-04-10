package questions;

public class Q_02_RatInMazeAllPaths {
//    public static void solveMaze(int[][] maze,int[][] path,int row, int col){
//
//
//        if(row<0 || col<0 || row>=maze.length || col>=maze[0].length || maze[row][col]==0 || path[row][col]==1){
//            return;
//        }
//        if(row == maze.length-1 && col == maze[0].length-1){
//            path[row][col] = 1;
//            // Print all path here
//            for (int[] ints : path) {
//                for (int j = 0; j < path[0].length; j++) {
//                    System.out.print(ints[j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//            path[row][col] = 0;
//            return;
//        }
//        path[row][col] = 1;
//        solveMaze(maze,path,row-1,col);
//        solveMaze(maze,path,row,col+1);
//        solveMaze(maze,path,row+1,col);
//        solveMaze(maze,path,row,col-1);
//        path[row][col] = 0;
//
//    }

    public static void solveMaze(int[][] maze,int[][] path,int row, int col){


        if(row<0 || col<0 || row>=maze.length || col>=maze[0].length || maze[row][col]==0 || path[row][col]==1){
            return;
        }
        if(row == maze.length-1 && col == maze[0].length-1){
            path[row][col] = 1;
            // Print all path here
            for (int[] ints : path) {
                for (int j = 0; j < path[0].length; j++) {
                    System.out.print(ints[j]+" ");
                }
            }
            System.out.println();
            path[row][col] = 0;
            return;
        }
        path[row][col] = 1;
        solveMaze(maze,path,row-1,col);
        solveMaze(maze,path,row+1,col);
        solveMaze(maze,path,row,col-1);
        solveMaze(maze,path,row,col+1);
        path[row][col] = 0;

    }

    public static void main(String[] args) {
        int[][] maze = {
                {1,0,1},
                {1,1,1},
                {1,1,1}};
        int[][] path = new int[3][3];
        solveMaze(maze,path,0,0);
    }
}
