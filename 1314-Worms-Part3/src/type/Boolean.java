package type;

public class Boolean extends T{
	
	public Boolean(boolean value){
		setBoolean(value);
	}
	
	public Boolean(){}
	
	public boolean getBoolean(){
		return this.value;
	}
	
	public void setBoolean(boolean value){
		this.value = value;
	}
	
	private boolean value = false;
}
