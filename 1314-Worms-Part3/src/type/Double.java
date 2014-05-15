package type;

import be.kuleuven.cs.som.annotate.Basic;

public class Double extends T implements Comparable<Double>{
	
	@Basic
	public double getDouble(){
		return this.value;
	}
	
	public void setDouble(double value){
		this.value = value;
	}
	
	private double value = 0;

	@Override
	public int compareTo(Double o) {
		if(this.getDouble() < o.getDouble())
			return -1;
		if(this.getDouble() > o.getDouble())
			return 1;
		return 0;
	}

}
