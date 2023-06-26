package doit.study2_stack;
//백준 #17608 막대기

import java.util.*;

class B17608 {
 public static void main(String[] args) {
    
    Stack<Integer> st = new Stack<> ();
    
    Scanner sc=new Scanner(System.in);
    
    //배열 크기 입력
    int n=sc.nextInt();
    
    //배열 선언 및 입력
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
       arr[i]=sc.nextInt();

    //스택 top이 배열값보다 작거나 같으면 가려져서 안브이므로 pop
    //결국 스택에는 보이는 막대기의 개수만 남음
    for(int i=0;i<arr.length;i++) {
          while(st.empty()==false && st.peek()<=arr[i]){ 
             st.pop();
          }
       st.push(arr[i]);
    }
    
    System.out.println(st.size());
 }
}