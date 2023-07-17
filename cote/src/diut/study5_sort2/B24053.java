package diut.study5_sort2;

//백준 #24053 알고리즘 수업 - 삽입 정렬 3

import java.util.*;
import java.io.*;

class B24053{

	public static int insertion_sort(int[] a,int[] b) {

		if(Arrays.equals(a,b))
			return 1;

		for(int i=1;i<a.length;i++) {
			int loc = i-1;
			int newItem = a[i];


			while(0<=loc && newItem < a[loc]) {

				a[loc+1]=a[loc];

				if(Arrays.equals(a,b))
					return 1;

				loc--;
			}

			if(loc+1 != i) {
				a[loc+1]=newItem;	

				if(Arrays.equals(a,b))
					return 1;
			}

		}

		return 0;
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] a = new int[n];
		int[] b = new int[n];

		for(int i=0;i<a.length;i++)
			a[i]=sc.nextInt();

		for(int i=0;i<b.length;i++)
			b[i]=sc.nextInt();

		System.out.println(insertion_sort(a,b));

	}												
}