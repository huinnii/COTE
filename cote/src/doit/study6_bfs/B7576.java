package doit.study6_bfs;

//백준 #7576 토마토

import java.util.*;

class B7576{

 static int N,M,cnt,max;

 static int[] dx = {0,1,0,-1};
 static int[] dy = {1,0,-1,0};

 static int[][] arr;
 static boolean[][] visited;
 
 static ArrayList<Integer[]> list;

 public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    int result=0;
    
    list = new ArrayList<>();
    M = sc.nextInt();
    N = sc.nextInt();
    max = 0;
    arr = new int[N][M];
    visited = new boolean[N][M];
    
    boolean all = true;

    for(int i=0;i<N;i++) {
       for(int j=0;j<M;j++) {
          arr[i][j] = sc.nextInt();
          if(arr[i][j]==0)
             all = false;
          if(arr[i][j]==1)
             list.add(new Integer[] {i,j});
       }
    }

    if(!all) {
       
       BFS();
       result=max-1;
       
       for(int i=0;i<N;i++) {
          for(int j=0;j<M;j++) {
             if(arr[i][j]==0)
                result=-1;
          }
       }
    }
    
    System.out.println(result);
 }   
 private static void BFS() {
    Queue<int[]> que = new LinkedList<>();
    
    for(int k=0; k<list.size(); k++) {
       int i= list.get(k)[0];
       int j= list.get(k)[1];
       
       que.offer(new int[] {i,j});
       visited[i][j]=true;
    }
    while(!que.isEmpty()) {
       int[] now = que.poll();

       for(int k=0;k<4;k++) {
          
          int x = now[0] + dx[k];
          int y = now[1] + dy[k];

          if(x>=0 && y>=0 && x<N && y<M) {
             if(arr[x][y] == 0 && !visited[x][y]) {
                visited[x][y]=true;
                arr[x][y] = arr[now[0]][now[1]] + 1;
                max=max<arr[x][y]?arr[x][y]:max;
                que.add(new int[] {x,y});
             }
          }
       }
    }
 }
}