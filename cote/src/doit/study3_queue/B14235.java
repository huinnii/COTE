package doit.study3_queue;

//백준 #14235 크리스마스 선물

import java.util.*;

public class B14235 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		//큰 수 우선순위 큐 -> 가장 가치가 큰 선물부터 주기 때문
		PriorityQueue<Integer> que = new PriorityQueue<>((o1,o2)-> {
			return o2-o1;
		});

		int n=sc.nextInt();   //거점지 바문 횟수
		int a=0;

		StringBuilder sb = new StringBuilder();

		for(int i=0;i<n;i++) {
			a=sc.nextInt();

			// 1. a=0일 때, 줄 선물이 없으면 -1 출력
			// 2. a=0일 때, 줄 선물이 있으면 그 선물의 가치를 출력
			// 3. a!=0일 때, a크기만큼 선물의 가치값을 큐에 add

			if(a==0) {
				if(que.isEmpty()==true)
					sb.append(-1).append("\n");
				else
					sb.append(que.poll()).append("\n");
			}
			else {
				for(int j=0;j<a;j++) {
					int b=sc.nextInt();
					que.add(b);
				}
			}
		}   
		System.out.println(sb);
	}

}
