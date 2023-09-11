package doit.study8_greedy;

//백준 #16953 A->B
/*
* 가능한 연산 1. 2를 곱하기 2. 1을 수의 가장 오른쪽에 추가
* 예제1 : 2 162 -> 5
*         2->4->8->81->162
* 예제2 : 4 42 -> -1
*         
* 예제3 : 100 40021 -> 5
*         100->200->2001->4002->40021
*/

import java.util.*;

class B16953{
 
 public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    
    int A = sc.nextInt();
    int B = sc.nextInt();
    
    //필요한 연산의 최솟값에 1을 더한 값을 출력
    int cnt = 1;
    
    while(true) {
       
       //B의 일의자리 숫자가 1이면 1 제거
       //B가 2로 나누어 떨어지면 2로 나누기
       //둘다 불가능하면 연산 불가
       if(B%10==1) {
          B=(B-1)/10;
       } else if(B%2==0){
          B/=2;
       } else {
          System.out.println(-1);
           break;
       }
       
       cnt++;
       
       //B가 A와 같아지면 연산 완료
       //B가 A보다 작아지면 연산 불가
       if(B==A) {
          System.out.println(cnt);
           break;
       }
       if(B<A) {
           System.out.println(-1);
           break;
       }
    }     
 }
}