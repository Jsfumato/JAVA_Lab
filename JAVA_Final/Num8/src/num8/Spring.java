package num8;

public class Spring extends TextView{
	private TextView textview;
	
	public Spring(TextView textview){
		this.textview = textview; 
	}
	public void viewing(){
		System.out.print("Spring ");
		this.textview.viewing();
	}
}
