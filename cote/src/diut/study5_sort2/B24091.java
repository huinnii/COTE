package diut.study5_sort2;
//백준 #24091 알고리즘 수업 - 퀵 정렬 2

import java.util.*;
import java.io.*;

class B24091{

	static int cnt=0;

	public static void quick_sort(int[] a,int left,int right,int k) {

		if(left < right) {
			int pivot = partition(a,left,right,k);
			quick_sort(a,left,pivot-1,k);
			quick_sort(a,pivot+1,right,k);
		}
	}

	//pivot을 제일 오른쪽값으로 지정
	public static int partition(int a[], int left, int right,int k) {

		int pivot = a[right];
		int start = left;
		int end = right-1;

		while( start < end) {

			if(a[start]<pivot) start++;

			if(a[end]>pivot) end--;

			else if (a[start] > pivot && a[end] < pivot) {
				int tmp=a[start];
				a[start++]=a[end];
				a[end--]=tmp;
			}
			
			//++cnt;
			if(++cnt==k) {
				for(int i=0;i<a.length;i++)
					System.out.print(a[i]+" ");
				System.out.println();
			}
		}

		if(a[start]<pivot) {
			int tmp=a[start+1];
			a[start+1]=pivot;
			a[right]=tmp;
          start++;
		}
		else if(a[start]>pivot) {
			int tmp=a[start];
			a[start]=pivot;
			a[right]=tmp;
		}

		//++cnt;
		if(++cnt==k) {
			for(int i=0;i<a.length;i++)
				System.out.print(a[i]+" ");
			System.out.println();
		}

		return start;
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] a = new int[n];

		for(int i=0;i<a.length;i++)
			a[i]=sc.nextInt();

		quick_sort(a,0,a.length-1,k);
		
//		for(int i=0;i<a.length;i++)
//			System.out.print(a[i]+" ");
//		
//		System.out.println(cnt);

		if(cnt<k)
			System.out.println(-1);
	}												

}