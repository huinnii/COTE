package doit.study4_sort1;

//백준 #23969 알고리즘 수업 - 버블 정렬 2

import java.util.*;
import java.io.*;

class B23969{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(s1);

		int n = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());

		String s2 = br.readLine();
		int[] arr=new int[n];
		String[] strArr = s2.split(" ");

		for(int i=0;i<strArr.length;i++) {
			arr[i]=Integer.parseInt(strArr[i]);
		}
		
		int cnt=0;
		StringBuffer sb = new StringBuffer();

		loop:		
			for(int i=0;i<n-1;i++) {
				for(int j=0;j<n-1-i;j++) {

					if(cnt==k) break loop;

					if(arr[j]>arr[j+1]) {
						int tmp = arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=tmp;
						cnt++;
					}
				}
			}

		if(cnt<k)
			sb.append("-1");
		else {
			for(int i=0;i<arr.length;i++)
				sb.append(arr[i]+" ");
		}

		System.out.println(sb);

	}

}