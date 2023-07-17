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

	public static int partition(int a[], int left, int right,int k) {
				
		int pivot = a[right];
		int start = left-1;

		for(int end=left;end<right;end++) {
			//a[start]는 pivot보다 작게, a[end]는 pivot보다 크게 해주는 작업 
			if(a[end]<=pivot) {
				int tmp=a[++start];
				a[start]=a[end];
				a[end]=tmp;
				
				if(++cnt == k) {
					for(int l=0;l<a.length;l++)
						System.out.print(a[l]+" ");
					System.out.println();
				}
			}
		}

		//start가 끝에 다다르지 않음 = pivot이 start 다음으로 삽입되어야 함
		if(start+1 != right) { 
			int tmp=a[start+1];
			a[start+1]=a[right]; //a[right]=pivot
			a[right]=tmp;
			
			if(++cnt == k) {
				for(int l=0;l<a.length;l++)
					System.out.print(a[l]+" ");
				System.out.println();
			}
		}

		return start+1;
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] a = new int[n];

		for(int i=0;i<a.length;i++)
			a[i]=sc.nextInt();
		
		quick_sort(a,0,a.length-1,k);
		
		if(cnt<k)
			System.out.println(-1);
	}												

}