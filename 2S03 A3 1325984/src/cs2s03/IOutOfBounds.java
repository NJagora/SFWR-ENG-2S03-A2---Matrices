package cs2s03;

public class IOutOfBounds extends Throwable{
	private int i;
	
	public IOutOfBounds (int i){
		this.i = i;
	}
	
	public String FormatError(){
		return "Exponent value i must be <= 0. Value entered: " + this.i; 
	}
}
