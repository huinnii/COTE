package doit.study5_sort3;

//백준 #1202 보석도둑

import java.util.*;

//보석 클래스
class Jewel{
	
	int weight;
	int price;

	Jewel(int weight,int price){
		this.weight=weight;
		this.price=price;
	}
}

//보석 리스트 정렬 -> 무게 가벼운 순으로 정렬
class JewelComparator implements Comparator<Jewel>{
	@Override
	public int compare(Jewel jw1,Jewel jw2) {
		return jw1.weight-jw2.weight;
	}
}

class B1202{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();	//보석 정보 개수
		int k = sc.nextInt();	//가방에 담을 수 있는 최대 무게

		//최대힙(큰 가격에서 작은 가격 순)
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});
		
		//보석 리스트
		ArrayList<Jewel> jewels = new ArrayList<>();
		//가방 리스트
		int[] bag=new int[k];

		//입력과 동시에 리스트에 추가
		for(int i=0;i<n;i++) {

			int m=sc.nextInt();
			int v=sc.nextInt();
			
			jewels.add(new Jewel(m,v));
		}
		
		for(int i=0;i<k;i++) {
			int c=sc.nextInt();
			bag[i]=c;
		}
		
		//보석리스트 - 무게 가벼운 순으로 정렬
		Collections.sort(jewels,new JewelComparator());
		//가방리스트 - 최대무게 가벼운 순으로 정렬
		Arrays.sort(bag);
		
		//보석 가격 합의 최댓값
		long sum=0;
		
		//1 가방에 넣을 수 있는 보석을 찾아 가격을 pq에 추가(가방의 수만큼 진행)
		//2. pq의 가장 앞에 있는 값(가방에 넣을 수 있는 가격 중 최대값)을 sum에 더함
		// -> pq를 poll하고 보석들이 남아 있을 수 있음 -> 가방 리스트를 무게 순으로 정렬해놨으므로 이 보석들은 다음 가방에 들어갈 수 있는 후보가 됨(초기화 필요 없음)
		//3. 보석 리스트의 마지막으로 추가했던 보석 이후의 인덱스부터 1,2번을 진행
		//4. while문 탈출 조건 : 보석이 pq에 모두 들어갔거나, 가방보다 보석의 무게가 크면 더이상 pq에 추가를 할 필요 없음
		
		int j=0; //보석 리스트 인덱스
		for(int i=0;i<k;i++) {
			// 가방에 넣을 수 있는 무게의 보석들은 모두 pq에 추가
			while(j<jewels.size()&&jewels.get(j).weight<=bag[i])
					pq.add(jewels.get(j++).price);
			// 가방에 들어갈 수 있는 보석 중 가장 비싼 보석을 가방에 넣기
			if(!pq.isEmpty()) {
				sum+=pq.poll();
			}
		}
		
		System.out.println(sum);
	}												
}