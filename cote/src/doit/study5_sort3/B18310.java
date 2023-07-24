package doit.study5_sort3;

//백준 #18310 안테나

import java.util.*;

public class B18310 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		
		//집 위치 배열
		int[] homes=new int[n];
		

		int maxID=0;
		for(int i=0;i<n;i++) {
			homes[i]=sc.nextInt();	
			maxID=Math.max(maxID,homes[i]);
		}
		
		Arrays.sort(homes);
		
		//결과
		int result=homes[0];
		
		int max=0;
		for(int i=1;i<homes.length;i++) {
			int distance=homes[i]-homes[i-1];
			if(max<distance) {
				max=distance;
				int middle=Math.round((float)maxID/2);
				int a=Math.abs(middle-homes[i-1]);
				int b=Math.abs(middle-homes[i]);
				if(a<b)
					result=homes[i-1];
				else
					result=homes[i];
			}
		}
				
		System.out.println(result);
	}
}
