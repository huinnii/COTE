package doit.study6_bfs;

//백준 #2178 미로 탐색

import java.util.*;

class CodingTest{

	static int N,M;

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N][M];
		visited = new boolean[N][M];

		for(int i=0;i<N;i++) {
			String str = sc.next();
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(str.substring(j,j+1));
			}
		}
		BFS(0,0);
		System.out.println(arr[N-1][M-1]);
	}   
	private static void BFS(int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {i,j});
		while(!que.isEmpty()) {
			int now[] = que.poll();
			visited[i][j]=true;

			for(int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];

				if(x>=0 && y>=0 && x<N && y<M) {
					if(arr[x][y]!=0 && !visited[x][y]) {
						visited[x][y]=true;
						arr[x][y]=arr[now[0]][now[1]] + 1;
						que.add(new int[] {x,y});
					}
				}
			}
		}
	}
}