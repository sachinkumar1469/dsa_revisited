import java.sql.SQLOutput;

public class Q_01_ShortestPath {
    // Given a string WNEENESENNN
    // Find the shortest path between (0,0) to final destingatio
    // W,N,E,S represent direction. 1 Unit

    public static void main(String[] args) {
        var path = "WWWS";
        int x = findShortestDistance(path);
        System.out.println(x);
    }

    private static int findShortestDistance(String path) {
        int x = 0;
        int y = 0;
        for(var i=0;i<path.length();i++){
            switch (path.charAt(i)){
                case 'W':
                    System.out.println("Here");
                    x--;
                case 'E':
                    x++;
                case 'N':
                    y++;
                case 'S':
                    y--;
                default:
            }
        }
        System.out.println("Final destination is: "+x+" "+y);
        return 1;
    }
}
