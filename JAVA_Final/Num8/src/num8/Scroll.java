package num8;

public class Scroll extends TextView{
	private TextView textview;
	
	public Scroll(TextView textview){
		this.textview = textview; 
	}
	public void viewing(){
		System.out.print("Scrolling ");
		this.textview.viewing();
	}
}
