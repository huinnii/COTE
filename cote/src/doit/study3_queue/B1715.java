package doit.study3_queue;

//백준 #1715 카드 정렬하기

import java.util.*;

public class B1715 {
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		//오름차순 우선순위큐
		//개수가 적은 카드묶음부터 비교해야 비교횟수가 최소가 됨
		PriorityQueue<Integer> que = new PriorityQueue<>();
//		((o1,o2)-> {
//			return o1-o2;
//		});

		int n=sc.nextInt();   //카드 묶음 개수
		int result=0;   //최소 비교 횟수

		//먼저 입력값을 작은 수 우선순위로 큐에 넣고,
		//앞의 두 수를 뽑아 더하고 다시 큐에 넣음으로써 
		//작은 수부터 이 과정을 진행할 수 있도록 구현

		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			que.add(num);
		}

		while(que.size()>1) {
			int a=que.poll();
			int b=que.poll();

			que.add(a+b);
			result+=(a+b);
		}

		System.out.println(result);
	}

}
