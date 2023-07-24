package doit.study5_sort3;

//백준 #10825 국영수

import java.util.*;

//학생 정보 클래스
class Student{
	String name;
	int kor;
	int eng;
	int math;

	Student(String name,int kor,int eng,int math){
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
}

//학생리스트 정렬을 위한 클래스
class StudentComparator implements Comparator<Student>{
	@Override
	public int compare(Student st1,Student st2) {
		
		//국어 점수 내림차순 정렬
				if(st1.kor<st2.kor)
					return 1;
				else if(st1.kor>st2.kor)
					return -1;
				else{
					//영어 점수 오름차순 정렬
					if(st1.eng>st2.eng)
						return 1;
					else if(st1.eng<st2.eng)
						return -1;
					else {
						//수학 점수 내림차순 정렬
						if(st1.math<st2.math)
							return 1;
						else if(st1.math>st2.math)
							return -1;
						else {
							//이름 사전 순 오름차순 정렬
							if(st1.name.compareTo(st2.name)>0)
								return 1;
							else if(st1.name.compareTo(st2.name)<0)
								return -1;
						}
					}
				}
				
				return 0;
	}
}

public class B10825 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//학생 수 입력
		int n=Integer.parseInt(sc.nextLine());
		
		//학생 리스트
		ArrayList<Student> studentsList = new ArrayList<>();

		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			String tmp[] = str.split(" ");
			
			String name=tmp[0];
			int kor=Integer.parseInt(tmp[1]);
			int eng=Integer.parseInt(tmp[2]);
			int math=Integer.parseInt(tmp[3]);

			Student st = new Student(name,kor,eng,math);

			studentsList.add(st);
		}

		Collections.sort(studentsList,new StudentComparator());

		Iterator<Student> it = studentsList.iterator();
		while(it.hasNext()) {
			Student st = it.next();
			System.out.println(st.name);
		}

	}
}
