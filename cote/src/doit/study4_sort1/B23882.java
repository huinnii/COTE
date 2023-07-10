package doit.study4_sort1;

//백준 #23882 알고리즘 수업 - 선택 정렬 2

import java.util.*;
import java.io.*;

class B23882{

	public static void selection_sort(int[] a,int k) {

		int cnt=0;
		boolean result=false;

		int last;
		for(last=a.length-1;last>=0;last--) {

			if(cnt==k) {
				result=true;
				break;
			}
			
			int max=last;

			for(int j=0;j<last;j++) {

				if(a[j]>a[max])		
					max=j;
			}
			
			if(max!=last) {
				int tmp=a[last];
				a[last]=a[max];
				a[max]=tmp;
				cnt++;
			}

		}

		if(result) {
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]+" ");
			System.out.println();
		}
		else
			System.out.println(-1);
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arr = new int[n];

		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();

		selection_sort(arr,k);

	}												

}