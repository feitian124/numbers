package numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Number {
	
	private static final int count = 45000;
	
	private static final int max = 200000;
	
	private static final int avg = 5000;
	
	private List<Integer> list = new ArrayList<>(count);
	
	private List<Group> groups = new ArrayList<>(count/100); 
	
	private Random random =new java.util.Random();
	
	public Number() {
		for(int i=0; i < count; i++) {
			list.add(next());
		}
	}
	
	public void sort() {
		Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
	}
	
	private int next() {
		return random.nextInt(max);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			sb.append(String.format("%-6s ", list.get(i)));
			if((i+1) % 20 == 0) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 将一个数组分成总和相等，数量相等的2个数组
	 * 输入的数组应该倒叙排序，使得较大的数可以先分配
	 */
	public static List<Group> divide(List<Group> groups, List<Integer> list) {
		int size = (int)Math.ceil(list.size()/2);
		Group g1 = new Group(size);
		Group g2 = new Group(size);
		for(int i=0; i<list.size(); i++) {
			if(i%2 == 0) {
				g1.add(list.get(i));
			} else {
				g2.add(list.get(i));
			}
		}
		if(g1.size() <= 100+1) { //份数够了
			groups.add(g1);
			groups.add(g2);
		} else {
			divide(groups, g1.getList());
			divide(groups, g2.getList());
		}
		return groups;
	}
	
	public static void main(String... args) {
		Number n = new Number();
		n.sort();
		Number.divide(n.groups, n.list);
		for(Group g: n.groups) {
			System.out.println(g);
		}
	}

}
