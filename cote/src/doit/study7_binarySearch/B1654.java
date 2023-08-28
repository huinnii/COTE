package doit.study7_binarySearch;
//백준 #1654 랜선 자르기

import java.util.*;

class B1654{
 
 public static void main(String[] args){
	 
	 /*
	  	4 11
		802
		743
		457
		539
	 */

    Scanner sc = new Scanner(System.in);
    
    // K = 가지고 있는 랜선의 개수
    // N = 필요한 랜선의 개수
    int K = sc.nextInt();
    int N = sc.nextInt();
    
    //랜선 배열
    int[] arr = new int[K];
    
    long max=0;
    
    for(int i=0;i<arr.length;i++) {
  	  arr[i]=sc.nextInt();
  	  max=max<arr[i]?arr[i]:max;
    }
    
    //랜선의 길이가 자연수이므로 start를 1로 초기화
    long start=1;
    //제일 긴 값을 기준으로 이분탐색해야하므로 end를 제일 긴 랜선값으로 설정
    long end=max;
           
    //이분탐색 구현
    while(start<=end) {
  	  long mid = (start+end) /2;
  	  
  	  int sum =0;
  	  
  	  for(int i=0;i<arr.length;i++) {
  		  sum += (arr[i]/mid);
  	  }
  	  
  	  if(sum>=N) {
  		  start = mid+1;
  	  }
  	  else {
  		  end = mid-1;
  	  }
    }
    
    System.out.println(end);
    
   }  
}