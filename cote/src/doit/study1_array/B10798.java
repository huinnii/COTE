package doit.study1_array;
//백준 #10798 세로읽기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10798{
   public static void main(String[] args) throws IOException {
        
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        //5x15 크기의 문자 배열 선언
      char[][] arr = new char[5][15];
       
        int max=0; //가장 긴 행의 길이
        //문자 배열에 입력 받기
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
            
            //max값과 각 행의 길이 비교
            max=(max < arr[i].length) ? arr[i].length:max;
        }
        
        for (int i = 0; i < max; i++) {
            for (int j=0; j < 5; j++) {
                //i(열)가 행의 길이보다 작을 때만 출력
               if(arr[j].length > i) 
                  System.out.print(arr[j][i]);
            }
        }
    }
}