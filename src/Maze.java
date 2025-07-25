import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
     //   System.out.println(count(3,3));
     //System.out.println( PathList("",3,3));
    //    System.out.println(PathListRet("",3,3));
//        boolean[][] board ={
//                {true,true,true},
//                {true,true,true},
//                {true,true,true}
//        };
  //      allPaths("",board,0,0);
        System.out.println( count(51,9));
    }
    static int count(int r, int c){
        if (r==1 || c == 1){
            return 1;
        }
        int left =  count(r-1,c);
        int right = count(r,c-1);

        return left + right;
    }
    static void Path(String p, int r,int c){
        if (r==1 && c ==1){
            System.out.println(p);
        }
        if (r > 1){
            Path(p+'D',r-1,c);
        }
        if (c > 1){
            Path(p+'R',r,c-1);
        }
    }
    static ArrayList<String> PathList(String p, int r, int c){
        if (r==1 && c ==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String > ans = new ArrayList<>();

        if (r > 1){
            ans.addAll(PathList(p+'D',r-1,c));
        }
        if (c > 1){
            ans.addAll(PathList(p+'R',r,c-1));
        }
        return ans;
    }
    static ArrayList<String> PathListRet(String p, int r, int c){
        if (r==1 && c ==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String > ans = new ArrayList<>();
        if (r>1 && c >1){
            ans.addAll(PathListRet(p+'D',r-1,c-1));
        }
        if (r > 1){
            ans.addAll(PathListRet(p+'V',r-1,c));
        }
        if (c > 1){
            ans.addAll(PathListRet(p+'H',r,c-1));
        }
        return ans;
    }
    static void PathRestrictions(String p,boolean[][] maze, int r,int c){
        if (r== maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c]){
            return;
        }
        if (r < maze.length-1){
            PathRestrictions(p+'D',maze,r+1,c);
        }
        if (c < maze[0].length-1){
            PathRestrictions(p+'R',maze,r,c+1);
        }
    }
    static void allPaths(String p, boolean[][] maze, int r, int c){
        if (r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if (!maze[r][c]){
            return;
        }
        // i am considering this block in my path
        maze[r][c] = false;

        if (r < maze.length -1){
            allPaths(p+'D',maze,r+1,c);
        }
        if (c< maze[0].length -1){
            allPaths(p+'R',maze,r,c+1);
        }
        if (r > 0){
            allPaths(p+'U',maze,r-1,c);
        }
        if (c > 0){
            allPaths(p+'L',maze,r,c-1);
        }
        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that where made by that function call
        maze[r][c] = true;
    }
}

