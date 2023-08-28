package doit.study7_binarySearch;

//백준 #2343 기타레슨

import java.util.Scanner;

public class B2343 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //강의 수
		int M = sc.nextInt(); //블루레이 수
		
		//강의 길이 배열
		int[] lesson =new int[N];
		
		int start = 0;
		int end = 0;
		for(int i=0;i<N;i++) {
			lesson[i] = sc.nextInt();
			
			//블루레이 사이즈는 가장 긴 길이의 강의~강의길이 총합까지 가능
			//start에는 강의길이 중 가장 긴 길이 설정
			if(start<lesson[i]) start = lesson[i]; 
			
			//end에는 모든 강의길이의 합을 설정
			end+=lesson[i];
		}
		
		//최적의 블루레이 사이즈를 찾기 위한 이분탐색 구현
		//sum에 0인덱스부터 강의를 담으면서 mid(블루레이 사이즈)와 비교하면서 진행
		while(start<=end) {
			int mid = (start+end)/2;
			int sum=0; //한 블루레이에 담는 강의의 길이 합
			int cnt=0; //현재 블루레이 개수
			for(int i=0;i<N;i++) {
				//강의길이 합이 블루레이 사이즈(mid)보다 크면 블루레이에 담고(cnt++), sum을 초기화
				if(sum+lesson[i]>mid) {
					cnt++;
					sum = 0;
				}
				//강의 담기
				sum += lesson[i];
			}
			//for문을 빠져나오고 마지막 강의가 존재하면 또 블루레이에 담기(cnt++)
			if(sum!=0)
				cnt++;
			
			//주어진 블루레이 개수보다 더 많이 담긴 경우 : ..
			if(cnt>M)
				start=mid + 1;
			//주어진 블루레이 개수보다 더 적게 담긴 경우 : ..
			else
				end = mid -1;
		}
		System.out.println(start);
	}
}
