package sort.examples;
import java.util.*;
class RemoveDuplicates{
static class Student implements Comparable<Student> {
	String firstName;
	String lastName;
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public int compareTo(Student st){
		int comFirst = firstName.compareTo(st.firstName);
		if(comFirst !=0) {
			return comFirst;
		}
		return lastName.compareTo(st.lastName);
	}
	@Override
	public String toString() {
		return firstName +"-"+lastName;
		
	}
}
	public static List<Student> removeDup(List<Student> st) {
		Collections.sort(st);
		Integer writeIndex=0;
		for(int i=1; i<st.size(); i++) {
			if(!st.get(writeIndex).firstName.equals(st.get(i).firstName)) {
				st.set(++writeIndex, st.get(i));
			}
		}
		System.out.println(st);
		//System.out.println(st.subList(writeIndex, st.size()));
		 st.subList(++writeIndex, st.size()).clear();
		 return st;
	}
	public static void main(String args[]) {
		List<Student> input = new ArrayList<Student>();
			input.add(new Student("Ian","Botham"));
			input.add(new Student("Ian", "Chappel"));
			input.add(new Student("David", "Gower"));
			input.add(new Student("Ian", "Bell"));
		
		System.out.println(removeDup(input));
	}
}

