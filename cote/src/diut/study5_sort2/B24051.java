package diut.study5_sort2;

//백준 #24051 알고리즘 수업 - 삽입 정렬 1

import java.util.*;
import java.io.*;

class B24051{

	public static int insertion_sort(int[] a,int k) {
		
		int cnt=0;
		
		for(int i=1;i<a.length;i++) {
			int loc = i-1;
			int newItem = a[i];
			
			if(cnt==k)
				return a[i];
			
			while(0<=loc && newItem < a[loc]) {
			
				a[loc+1]=a[loc];
				
				if(++cnt ==k)
					return a[loc+1];
				
				loc--;
			}
			
			if(loc+1 != i) {

				a[loc+1]=newItem;	
				
				if(++cnt ==k)
					return a[loc+1];
			}
			
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();	//배열의 K번째 원소

		int[] arr = new int[n];

		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();

		System.out.println(insertion_sort(arr,k));

	}												

}