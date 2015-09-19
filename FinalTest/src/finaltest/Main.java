package finaltest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

import finaltest.passenger.MakePassengerList;
import finaltest.passenger.Passenger;
import finaltest.passenger.ResultList;
import finaltest.policy.DefaultPolicy;
import finaltest.station.Platform;
import finaltest.station.TicketBooth;
import finaltest.station.TravelTimeTable;


public class Main {
	public static int curTime = 0;	
	public static void main(String[] args) {
		
//		�°� ����Ʈ ����
		ArrayList<Passenger> passengerList = MakePassengerList.makeList();

//		�°� ���� booth ����
		TicketBooth booth = new TicketBooth();
		
//		���� ����� �÷���
		Platform platform = Platform.getInstance();
		TravelTimeTable.showTable();
		
//		���� cycle
//		��� �°��� ����� ���� ������ ���ư��ϴ�.
		while(ResultList.getNumOfResult() < 50){
			System.out.println("**** ����ð� : "+curTime+"�� *********************");
			System.out.println("============= ����ð� ���� �ν� ���� �� =============");
			System.out.println("[���̵�]\t[�̸�]\t[�ν�����]\t[��ǥ�ҿ�]\t[�̵��ҿ�]");
			Iterator<Passenger> iter = passengerList.iterator();
			while(iter.hasNext()){
				Passenger c = iter.next();
				System.out.println(c);
				if(curTime == c.getArrivalTime()){
					booth.addWaitingQueue(c);
					iter.remove();
				}
			}
//			booth.showReadyQueue();
			booth.doTicketing();
			booth.showTicketing();
			booth.showReadyQueue();
			platform.leaveTrain();
			platform.showTrainWaiting();
			curTime++;
		}
		ResultList.showResult();
		ResultList.makeResultFile("Result_2");
	}

}
