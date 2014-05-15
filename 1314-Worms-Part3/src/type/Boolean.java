package type;

public class Boolean extends T{
	
	public boolean getBoolean(){
		return this.value;
	}
	
	public void setBoolean(boolean value){
		this.value = value;
	}
	
	private boolean value = false;
}
