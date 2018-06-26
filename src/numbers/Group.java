package numbers;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private int max = 0;

	private int min = Integer.MAX_VALUE;

	private int total = 0;

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

		if (e > max) {
			max = e;
		}

		if (e < min) {
			min = e;
		}

		total += e;

		list.add(e);
	}

	public int size() {
		return list.size();
	}

	public String toString() {
		return String.format("max: %6d, min: %5d, quantity: %3s, total: %7d, avg: %8d", max, min, list.size(), total,
				total / list.size());
	}

}
