package doit.study2_stack;
//백준 #17298 오큰수

import java.util.*;
import java.io.*;

class B17298 {
 public static void main(String[] args) throws IOException {
          
    BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    
    //수열 A의 크기
    int n=Integer.parseInt(br.readLine());
    
    //배열 선언 및 입력
    int[] arr=new int[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    for(int i=0;i<n;i++) {
       arr[i]=Integer.parseInt(st.nextToken());
    }
    
    Stack<Integer> stack = new Stack<> ();
    //arr[top]과 arr[i]를 비교 
    //arr[top]이 작으면 top인덱스의 오큰수로 arr[i] 저장
    
    for(int i=0;i<arr.length;i++) {
       while(stack.empty()==false && arr[stack.peek()]<arr[i]) {
          arr[stack.pop()]=arr[i];
       }
       stack.push(i);
    }
    
    //남은 값들은 -1로 초기화
    while(stack.empty()==false) {
       arr[stack.pop()]=-1;
    }   
    
    //배열값을 sb로 옮김
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++) {
       sb.append(arr[i]).append(' ');
    }
    
    System.out.println(sb);
 }
}