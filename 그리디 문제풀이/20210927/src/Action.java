
class Action implements Comparable<Action>{
	String name;
	
	int startTime;
	
	int endTime;
	
	public Action() {
	}
	
	public Action(String name, int startTime, int endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Action a) {
		return this.endTime - a.endTime;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
