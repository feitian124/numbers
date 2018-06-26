package numbers;

import java.util.ArrayList;
import java.util.List;

public class Group {
	
	private int max=0;
	
	private int min=Integer.MAX_VALUE;
	
	private List<Integer> list;
	
	public Group(int size) {
		list = new ArrayList<>(size);
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	public void add(int e) {
		
		if(e > max) {
			max = e;
		}
		
		if(e < min) {
			min = e;
		}
		
		list.add(e);
	}
	
	public int size() {
		return list.size();
	}
	
	public String toString() {
		return String.format("max: %d, min: %d, quantity: %s, numbers: %s", max, min, list.size(), list);
	}

}
