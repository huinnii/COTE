package doit.study6_bfs;

//백준 #4963 섬의 개수

import java.util.*;

class B4963{

 static int h,w; //h: 높이 , w: 너비
 static int cnt;

 static int[] dx = {0,1,0,-1,1,-1,1,-1};
 static int[] dy = {1,0,-1,0,1,1,-1,-1};

 static int[][] arr;
 static boolean[][] visited;

 public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    while(true) {
       w = sc.nextInt();
       h = sc.nextInt();
       
       if(h==0 && w==0)
          break;

       cnt=0;

       arr = new int[h][w];
       visited = new boolean[h][w];

       for(int i=0;i<h;i++) {
          for(int j=0;j<w;j++) {
             arr[i][j]=sc.nextInt();
          }
       }

       for(int i=0;i<h;i++) {
          for(int j=0;j<w;j++) {
             if(arr[i][j]!=0 && !visited[i][j]) {
                BFS(i,j);
                cnt++;
             }
          }
       }
       System.out.println(cnt);
    }
 }   
 private static void BFS(int i, int j) {
    Queue<int[]> que = new LinkedList<>();
    que.offer(new int[] {i,j});
    visited[i][j]=true;
          
    while(!que.isEmpty()) {
       int[] now = que.poll();

       for(int k=0;k<8;k++) {
          int x = now[0] + dx[k];
          int y = now[1] + dy[k];

          if(x>=0 && y>=0 && x<h && y<w) {
             if(arr[x][y]!=0 && !visited[x][y]) {
                visited[x][y]=true;
                que.add(new int[] {x,y});
             }
          }
       }
    }


 }
}