package questions;

public class Q_01_RatInMaze {

    public static void findPath(int[][] maze, int[][] path,int row,int col){
        System.out.println("Called with "+row+" "+col);
        if(row==maze.length-1 && col==maze[0].length-1){
//            if(path[path.length-1][path[0].length-1]==1)
            System.out.println("Reached");
            return;
        }
//        if(row<0 || col<0 || row>=maze.length || col>=maze[0].length){
//            System.out.println("Dead end");
//            return;
//        }
        // Either go top,right,bottom or left

        // Top
        int newRow = row-1;
        if(!(newRow<0)) {
            System.out.println("Top path at "+row+col+" "+path[newRow][col]);
            if(path[newRow][col]!=1 && maze[newRow][col]!=0){
                path[newRow][col] = 1;
                findPath(maze,path,newRow,col);
                if(path[path.length-1][path[0].length-1]==1){
                    return;
                }
                path[newRow][col] = 0;
            }
        }

        // Right
        int newCol = col+1;
        if(!(newCol>=maze[0].length)){
            if(path[row][newCol]!=1 && maze[row][newCol]!=0){
                path[row][newCol] = 1;
                findPath(maze,path,row,newCol);
                if(path[path.length-1][path[0].length-1]==1){
                    return;
                }
                path[row][newCol] = 0;
            }
        }

        // Down
        newRow = row + 1;
        if(!(newRow>=maze.length)){
            if(path[newRow][col]!=1 && maze[newRow][col]!=0){
                path[newRow][col] = 1;
                findPath(maze,path,newRow,col);
                if(path[path.length-1][path[0].length-1]==1){
                    return;
                }
                path[newRow][col] = 0;
            }
        }

        // Left
        newCol = col - 1;
        if(!(newCol<0)){
            if(path[row][newCol]!=1 && maze[row][newCol]!=0){
                path[row][newCol] = 1;
                findPath(maze,path,row,newCol);
                if(path[path.length-1][path[0].length-1]==1){
                    return;
                }
                path[row][newCol] = 0;
            }
        }

        System.out.println(">>>>>>> Dead End at: "+row+" "+col);
    }

    public static boolean solveMaze(int[][] maze, int[][] path,int row,int col){
        if(row==maze.length-1 && col==maze[0].length-1){
            return true;
        }
        // Either go top,right,bottom or left

        // Top
        int newRow = row-1;
        if(!(newRow<0)) {
            if(path[newRow][col]!=1 && maze[newRow][col]!=0){
                path[newRow][col] = 1;
                if(solveMaze(maze,path,newRow,col)){
                    return true;
                }
                path[newRow][col] = 0;
            }
        }

        // Right
        int newCol = col+1;
        if(!(newCol>=maze[0].length)){
            if(path[row][newCol]!=1 && maze[row][newCol]!=0){
                path[row][newCol] = 1;
                if(solveMaze(maze,path,row,newCol)){
                    return true;
                }
                path[row][newCol] = 0;
            }
        }

        // Down
        newRow = row + 1;
        if(!(newRow>=maze.length)){
            if(path[newRow][col]!=1 && maze[newRow][col]!=0){
                path[newRow][col] = 1;
                if(solveMaze(maze,path,newRow,col)){
                    return true;
                }
                path[newRow][col] = 0;
            }
        }

        // Left
        newCol = col - 1;
        if(!(newCol<0)){
            if(path[row][newCol]!=1 && maze[row][newCol]!=0){
                path[row][newCol] = 1;
                if(solveMaze(maze,path,row,newCol)){
                    return true;
                }
                path[row][newCol] = 0;
            }
        }

        return false;
    }

    // Clean and simpler code
    public static boolean solveMaze2(int[][] maze,int[][] path, int row, int col){
        int rowLength = maze.length;
        if(row<0 || col>=maze[0].length || row>=rowLength || col<0 || maze[row][col]==0 || path[row][col]==1){
            return false;
        }
        path[row][col] = 1;
        if(row == rowLength-1 && col == maze[0].length-1){
            return true;
        }
        if(solveMaze2(maze,path,row-1,col)){
            return true;
        }
        if(solveMaze2(maze,path,row,col+1)){
            return true;
        }
        if(solveMaze2(maze,path,row+1,col)){
            return true;
        }
        if(solveMaze2(maze,path,row,col-1)){
            return true;
        }
        path[row][col]=0;
        return false;
    }
    public static void main(String[] args) {
        int[][] maze = {{1,1,0},{1,1,0},{1,1,1}};
        int[][] path = new int[3][3];
//        findPath(maze,path,0,0);
        System.out.println(solveMaze2(maze,path,0,0));
    }

}
