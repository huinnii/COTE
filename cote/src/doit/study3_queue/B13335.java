package doit.study3_queue;

//백준 #13335 트럭

import java.util.*;

class B13335{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		Queue<Integer> que = new LinkedList<>();

		int n=sc.nextInt();   //트럭개수
		int w=sc.nextInt();   //다리길이
		int L=sc.nextInt();   //최대하중
		int result=0;   //최단시간

		int[] arr=new int[n+1];

		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		//큐 사이즈는 w, 들어가는 수의 합이 L보다 크면 안됨
		int cnt=0;
		int i=0;

		arr[n]=0;   //

		while(i<n) {
			if(que.size()==w) {   //조건1. 다리 큐가 꽉 찼을 때 poll
				cnt-=arr[que.poll()];
			}

			if((cnt+arr[i]) > L) {   //조건2. 최대하중이 넘으면 0값 add
				que.add(n);
			}
			else {   //그 외 add
				que.add(i);
				cnt+=arr[i];
				i++;
			}

			result++;   //시간+1
		}

		//마지막 트럭 빠져나가는 시간 w 더하기
		result+=w;

		System.out.println(result);
	}
}