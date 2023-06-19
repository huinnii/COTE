package doit.study1_twopointer;
//백준 #2003 수들의 합2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2003{
   public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
   
       //데이터 수 N, i부터 j까지의 합 M 입력
      int N=Integer.parseInt(st.nextToken());
      int M=Integer.parseInt(st.nextToken());

        //N 크기의 배열 arr 선언 및 입력
      int[]arr=new int[N]; 
      st = new StringTokenizer(br.readLine());
      
      for(int i=0;i<N;i++)
          arr[i]=Integer.parseInt(st.nextToken());
      
      
      //투포인터 사용
      
      int count = 0;  //경우의 수
      int start_idx=0;    //시작 포인터(i)
      int end_idx=0;  //끝 포인터(j)
      int sum=arr[0]; //arr[i]~arr[j]까지의 합(구간합이라 하겠음)
      
      while(true){
          if(sum==M){ //구간합이 M과 같을 때
          
              //경우의 수+1, 끝 포인터 한 칸 이동
              count++; end_idx++; 
              //끝 포인터가 배열 끝에 다다랐을 때 반복문 탈출    
              if(end_idx==N) break;
                //구간합에 끝 배열값 더함    
              sum+=arr[end_idx];
          }
          else if(sum>M){ //구간합이 M보다 클 때
              
              //구간합에서 첫 배열값 뺌
              sum-=arr[start_idx];
              //첫 포인터 한 칸 이동
              start_idx++;
          }
          else{   //구간합이 M보다 작을 때
              
              //끝 포인터 한 칸 이동
              end_idx++;
                //끝 포인터가 배열 끝에 다다랐을 때 반복문 탈출
              if(end_idx==N) break;
                //구간합에 끝 배열값 더함
              sum+=arr[end_idx];
          }
      }
      System.out.println(count);
   }
}