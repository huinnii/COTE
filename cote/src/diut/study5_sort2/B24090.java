package diut.study5_sort2;

//백준 #24090 알고리즘 수업 - 퀵 정렬 1

import java.util.*;
import java.io.*;

class B24090{

	static int cnt=0;

	public static void quick_sort(int[] a,int p,int r,int k) {

		if(p < r) {
			int q = partition(a,p,r,k);
			quick_sort(a,p,q-1,k);
			quick_sort(a,q+1,r,k);
		}
	}

	public static int partition(int a[], int p, int r,int k) {
				
		int x = a[r];
		int i = p-1;

		for(int j=p;j<r;j++) {
			if(a[j]<=x) {
				int tmp=a[++i];
				a[i]=a[j];
				a[j]=tmp;
				
				if(++cnt == k) {
					System.out.println(a[i]+" "+a[j]);
				}
			}
		}

		if(i+1 != r) {
			int tmp=a[i+1];
			a[i+1]=a[r];
			a[r]=tmp;
			
			if(++cnt == k) {
				System.out.println(a[i+1]+" "+a[r]);
			}
		}

		return i+1;
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