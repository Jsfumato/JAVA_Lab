package num8;

public class DecoTest {

	public static void main(String[] args) {
		
		TextView text1 = new TextView();
		text1.viewing();
		
		TextView text2 = new Spring(new LineText(new TextView()));
		text2.viewing();
		
		TextView text3 = new LineText(new Scroll(new Bordering(new TextView())));
		text3.viewing();
	}
}
