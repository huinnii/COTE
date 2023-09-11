package doit.study8_greedy;

//백준 #2839 설탕 배달

/*
* 3kg,5kg 봉지가 있음
* Nkg 배달해야 할 때 필요한 최소 봉지 개수
* 
* 예제1 : 18 = 5*3 + 3*1 -> 4
* 예제2 : 4 -> -1
* 예제3 : 6 = 3*2 -> 2
* 예제4 : 11 = 5*1 + 3*2 -> 3
*/

import java.util.*;

class B2839{
 
 public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    
    int cnt = 0;
    
    while(true) {
       
       //1. N이 5로 나누어 떨어지면 N에서 5 빼기
       //2. N이 3으로 나누어 떨어지면 N에서 3 빼기
       //3. 그 외 나누어 떨어지지 않으면서 5보다 크면 5 빼기
       //4. 그 외 나누어 떨어지지 않으면서 5보다 작으면 3 빼기
       if(N%5==0) N-=5;
       else if(N%3==0) N-=3;
       else if(N>5) N-=5;
       else if(N<5) N-=3;
       
       cnt++;
       
       //N이 0이 되었다는 것은 정확하게 Nkg을 만족했다는 것이므로 cnt 출력
       if(N==0) {
           System.out.println(cnt);
           break;
       }
       //N이 3보다 작으면 더이상 정확하게 Nkg을 만족하지 못하므로 -1 출력
       if(N<3) {
          System.out.println(-1);
          break;
       }
    }
    
 }
}