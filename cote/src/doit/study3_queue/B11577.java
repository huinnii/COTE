package doit.study3_queue;

//백준 #11577 Condition of deep sleep

import java.util.*;

class B11577{

   public static void main(String[] args){

      Scanner sc = new Scanner(System.in);

      Queue<Integer> que = new LinkedList<>();

      int n=sc.nextInt();   //전구의 개수
      int k=sc.nextInt();   //상태를 반전시킬 수 있는 연속된 전구의 개수
      int[] state = new int[n]; //전구상태 배열
      int result=0; //최소한의 버튼 조작 횟수

      for(int i=0;i<n;i++) {
         state[i]=sc.nextInt();
      }

      //그리디알고리즘 > 각 단계에서 가장 최선의 선택을 하는 기법
      //백준 제출 : 메모리 114280KB / 시간 1320ms
      //i=0부터 i번째 전구가 켜져있으면 k만큼 값을 반전시킴

      //      for(int i=0;i<n;i++) {
      //         if(state[i]==1 && i<=n-k) {
      //            for(int j=i;j<i+k;j++) {
      //               state[j]=state[j]^1;   //0^1=1 , 1^1=0
      //            }
      //            result++;
      //         }
      //      }

      //그리디 + 큐
      //백준 제출 : 메모리 115244KB / 시간 884ms
      //그리디만 이용하면 어떤 전구는 켜졌다 꺼졌다를 반복하며 배열에 저장되므로 시간이 오래 걸림
      //i번째를 반전시킬 때, i+k-1을 큐에 add함으로써 i부터 i+k-1이 반전되었음을 저장

      for(int i=0;i<n;i++) {
         // i번째 이전 인덱스는 poll
         while(que.isEmpty()==false && que.peek()<i) {
            que.poll();
         }

         // 0~i-1까지 오면서 반전된 상태를 반영하는 동작
         // 큐에 i(~i+k-1) 상태만 남아있는 상태에서 
         // i가 짝수면 그대로 , 홀수면 반전
         if(que.size()%2==1)
            state[i]=state[i]^1;

         //i~i+k-1까지 반전 상태 큐에 저장(i<=n-k일 때만 가능한 동작)
         if(i<=n-k) {
            
            //최종 반전 동작
            //i번째 전구가 켜져있으면 전구 끄고 반전횟수+1
            //i+k-1을 큐에 add : i부터 i+k-1을 반전시킴을 의미
            if(state[i]==1) {
               state[i]=state[i]^1;
               result++;
               que.add(i+k-1);
            }
         }
      }

      
      //위 반복문이랑 같은 동작
      //0~n-k / n-k+1~n-1 분리
      //
      //      for(int i=0;i<=n-k;i++) {
      //         while(que.isEmpty()==false && que.peek()<i) {
      //            que.poll();
      //         }
      //         
      //         if(que.size()%2==1)
      //            state[i]=state[i]^1;
      //      
      //         if(state[i]==1 && i<=n-k) {
      //            state[i]=state[i]^1;
      //            result++;
      //            que.add(i+k-1);
      //         }
      //      }
      //큐에 남은 전구들 후처리
      //      for(int i=n-k+1;i<n;i++) {
      //         while(que.isEmpty()==false && que.peek()<i){
      //            que.poll();
      //         }
      //         if(que.size()%2==1) {
      //            state[i]=state[i]^1;
      //         }
      //      }

      
      //모두 0이면(꺼져있으면) 반전시킨 횟수 출력
      //state 배열값이 하나라도 1이면(켜져있으면) Insomnia 출력

      boolean check=true;
      for(int i=0;i<n;i++) {
         if(state[i]==1) {
            check=false;
            break;
         }
      }

      if(check)
         System.out.println(result);
      else
         System.out.println("Insomnia");

   }

}