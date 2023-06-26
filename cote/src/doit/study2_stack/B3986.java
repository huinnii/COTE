package doit.study2_stack;
//백준 #3986 좋은 단어

import java.util.*;

class B3986 {
 public static void main(String[] args) {
    
    Stack<Character> st = new Stack<> ();
    
    Scanner sc=new Scanner(System.in);
    
    //단어 수 입력
    int n=sc.nextInt();
    
    //배열 선언 및 입력
    String[] arr=new String[n];
    for(int i=0;i<n;i++)
       arr[i]=sc.next();

    //좋은 단어 개수
    int result=0;
    
    for(int i=0;i<arr.length;i++) {
       
       st.clear();   //스택 초기화
       
       for(int j=0;j<arr[i].length();j++) {
       
          //스택이 비어있지 않을 떄, 짝(top=j번째 문자)을 찾으면
          if(st.empty()==false && st.peek()==arr[i].charAt(j)){
                st.pop();
          }else {   //그 외에는 push
             st.push(arr[i].charAt(j));
          }
       }
       
       //짝을 찾아서 스택이 모두 비었을 때 좋은 단어+1
       if(st.empty()==true)
          result++;
    }
    
    System.out.println(result);
 }
}