package doit.study6_bfs;

//백준 #2468 안전 영역

import java.util.*;

class B2468{

 static int N;
 static int cnt,max;
 static int max_height;

 static int[] dx = {0,1,0,-1};
 static int[] dy = {1,0,-1,0};

 static int[][] arr;
 static boolean[][] visited;

 public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();

    arr = new int[N][N];

    max_height=0;

    for(int i=0;i<N;i++) {
       for(int j=0;j<N;j++) {
          arr[i][j] = sc.nextInt();
          max_height=max_height<arr[i][j]?arr[i][j]:max_height;
       }
    }
    
    for(int k=0; k<max_height; k++) {
       cnt=0;
       
       visited = new boolean[N][N];
                
       for(int i=0;i<N;i++) {
          for(int j=0;j<N;j++) {

             if(arr[i][j] > k && !visited[i][j]) {
                BFS(i,j,k);
                cnt++;
             }

             max=max<cnt?cnt:max;
          }
       }
    }
    System.out.println(max);
 }   
 private static void BFS(int i, int j,int h) {
    Queue<int[]> que = new LinkedList<>();
    que.offer(new int[] {i,j});
    visited[i][j]=true;

    while(!que.isEmpty()) {
       int[] now = que.poll();

       for(int k=0;k<4;k++) {
          int x = now[0] + dx[k];
          int y = now[1] + dy[k];

          if(x>=0 && y>=0 && x<N && y<N) {
             if(arr[x][y]>h && !visited[x][y]) {
                visited[x][y]=true;
                que.add(new int[] {x,y});
             }
          }
       }
    }
 }
}