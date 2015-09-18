package finaltest.station;

import java.util.Iterator;
import java.util.PriorityQueue;

import finaltest.Main;
import finaltest.passenger.Passenger;
import finaltest.passenger.ResultList;
import finaltest.policy.DefaultPolicy;


public class Platform {
	
//	�̱���
	private Platform(){
		TravelTimeTable.makeTimeTable();
	};
	public static Platform platform = new Platform();
	public static Platform getInstance(){
		if(platform == null){
			platform = new Platform();
			return platform;
		}
		return platform;
	}

//	������ �޼ҵ�
	private final int TERM = 3;
	private PriorityQueue<Passenger> trainWaitingQueue = new PriorityQueue<Passenger>(50, new DefaultPolicy());
	
	public boolean checkTrainLeave(){
		return (Main.curTime % TERM == 0) ? true : false;
	}
	
	public void addTrainWaitingQueue(Passenger p){
		trainWaitingQueue.add(p);
	}
	
	public void leaveTrain(){
		if(checkTrainLeave()){
			System.out.println("[ ���� ����մϴ� ]");
			Iterator<Passenger> iter = trainWaitingQueue.iterator();
			while(iter.hasNext()){
				Passenger p = iter.next();
				p.setLeaveTime(Main.curTime);
				p.setFinalTime(p.getLeaveTime() + p.getTravelTime());
				ResultList.addResult(p);
			}
			trainWaitingQueue.clear();
			trainWaitingQueue = new PriorityQueue<Passenger>(50, new DefaultPolicy());
		}
	}
	
	public void showTrainWaiting(){
		System.out.println("============= ���� ��� �°� =============");
		System.out.println("[���̵�]\t[�̸�]\t[�ν�����]\t[��ǥ�ҿ�]\t[�̵��ҿ�]");
		Iterator<Passenger> iter = trainWaitingQueue.iterator();
		while(iter.hasNext()){
			Passenger c = iter.next();
			System.out.println(c);
		}
		System.out.println();
	}	
}
