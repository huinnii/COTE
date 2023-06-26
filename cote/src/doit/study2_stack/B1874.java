package doit.study2_stack;
//백준 #1874 스택 수열

import java.util.*;

class B1874 {
 public static void main(String[] args) {
    
    Stack<Integer> st = new Stack<> ();
    
    Scanner sc=new Scanner(System.in);
    
    //수열 크기 입력
    int n=sc.nextInt();
    
    //수열 선언 및 입력
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
       arr[i]=sc.nextInt();

    int num=1; //1~n
    StringBuffer sb = new StringBuffer();   //+,- 넣을 곳
    
    boolean flag=true; //수열 구현 가능 여부
    
    for(int i=0;i<arr.length;i++){
       if(arr[i]>=num){
          while(arr[i]>=num) {
             st.push(num++);
             sb.append("+\n");
          }
          st.pop();
          sb.append("-\n");
       }
       else {
          if(st.pop()>arr[i]) {
              System.out.println("NO");
             flag=false;
             break;
          }
          else {
             sb.append("-\n");
          }
       }
    }
    
    if(flag==true)
       System.out.println(sb);
 }
}