

class RatInAMaze{
     public static ArrayList<String> printPath(int[][] m, int n)
     {
          ArrayList<String> res = new ArrayList<String>();
          boolean[][] visited = new boolean[n][n];
          traverseMaze(m,n,visited,0,0,"",res);
          return res;
     }
     
     public static void traverseMaze(int[][] maze,int n,boolean[][] visited,int i,int j,String currPath,ArrayList<String> res){
         if(i==n-1 && j ==n-1){
             res.add(currPath);
             return;
         }
         visited[i][j] = true;
         if(i<n-1 && !visited[i+1][j] && maze[i+1][j]==1){
            traverseMaze(maze,n,visited,i+1,j,currPath+"D",res);
         }
         if(j>0 && !visited[i][j-1] && maze[i][j-1]==1){
            traverseMaze(maze,n,visited,i,j-1,currPath+"L",res);
         }
         if(j<n-1 && !visited[i][j+1] && maze[i][j+1]==1){
            traverseMaze(maze,n,visited,i,j+1,currPath+"R",res);    
         }
         if(i>0 && !visited[i-1][j] && maze[i-1][j]==1){
            traverseMaze(maze,n,visited,i-1,j,currPath+"U",res);
         }
         visited[i][j] = false;
     }
}