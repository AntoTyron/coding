package sort.examples;

//3,13,17, , , , , 
//3,7,11,19
//2ndlast < 1stlast move 1stLast to m+n-1, decrement 1stLast
//else move 2nd LAsst to m+n-1, decrement 2ndLast
import java.util.*;
class MergeSortedArrays{
	public static List<Integer> merge(List<Integer> first, List<Integer> sec) {
		Integer fLast = 3;    //3
		Integer sLast = sec.size();   //4
		Integer pos = fLast+sLast-1; //6
		while (fLast>0 && sLast >0 ){
			if(sec.get(sLast-1) < first.get(fLast-1)) {  //19<17, 11<17, 11<13, 11<3
				first.set(pos--, first.get(fLast-1)); //3,13,17, , 13,17 ,19
				fLast--;
			}
			else{
				first.set(pos--, sec.get(sLast-1)); //3,13,17, , , ,19 //3,3,7,11 , 13,17 ,19
				sLast --;
				//pos--;
			}
		}
		return first;

	}
	public static void main(String args[]) {
		List<Integer> first = Arrays.asList(3,13,17,null,null,null,null,null);
		//List<Integer> first = Arrays.asList(3,13,17);
		List<Integer> sec =  Arrays.asList(3,7,11,19);
		System.out.println(merge(first,sec));
	}

}

