package finaltest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import passenger.MakePassengerList;
import passenger.Passenger;
import policy.DefaultPolicy;
import station.TicketBooth;

public class Main {
	public static int curTime = 0;
	public static PriorityQueue<Passenger> queue = new PriorityQueue<Passenger>(50, new DefaultPolicy());
	
	public static void main(String[] args) {
		
//		�°� ����Ʈ ����
		ArrayList<Passenger> passengerList = MakePassengerList.makeList();

//		�°� ���� booth ����
		TicketBooth booth = new TicketBooth();
		
		while(curTime < 43){
			Iterator<Passenger> iter = passengerList.iterator();
			while(iter.hasNext()){
				Passenger c = iter.next();
				if(curTime == c.getArrivalTime()){
					booth.addWaitingQueue(c);
				}
			}
			
			booth.doTicketing();
			curTime++;
		}
		
		booth.showQueue();
		

		
	}

}
