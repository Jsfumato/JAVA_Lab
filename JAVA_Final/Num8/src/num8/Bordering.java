package num8;

public class Bordering extends TextView{
	private TextView textview;
	
	public Bordering(TextView textview){
		this.textview = textview; 
	}
	public void viewing(){
		System.out.print("Bordering ");
		this.textview.viewing();
	}
}
