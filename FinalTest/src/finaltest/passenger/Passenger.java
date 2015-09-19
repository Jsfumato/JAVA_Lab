package finaltest.passenger;

import finaltest.Main;
import finaltest.station.TravelTimeTable;

public class Passenger {

	private int id;
	private String name;
	private int arrivedTime;
	private int ticketingTime;
	private String stationFrom;
	private String stationTo;
	private int leaveTime;
	private int finalTime;
	
	private int ticketingStart;
	
//	������
	Passenger(String[] token){
		this.id = Integer.parseInt(token[0]);
		this.name = token[1];
		this.arrivedTime = Integer.parseInt(token[2]);
		this.ticketingTime = Integer.parseInt(token[3]);
		this.stationFrom = token[4];
		this.stationTo = token[5];
		this.ticketingStart = -1;
	}
	
	public void setTicketingStart(int time){
		this.ticketingStart = time;
	}
	public int getId(){
		return this.id;
	}
	public int getArrivalTime(){
		return this.arrivedTime;
	}
	public int getTicketingTime(){
		return this.ticketingTime;
	}
	public int getTravelTime(){
		return TravelTimeTable.travelTime(stationFrom, stationTo);
	}
	public int getTicketingReady(){
		if(ticketingStart == -1)
			return Main.curTime - this.arrivedTime;
		return ticketingStart - this.arrivedTime;
	}
	public int getTrainReady(){
		return leaveTime - (arrivedTime+getTicketingReady()+getTicketingTime());
	}
	public int getLeaveTime(){
		return this.leaveTime;
	}
	public int getFinalTime(){
		return finalTime;
	}
	
	public void setFinalTime(int time){
		this.finalTime = time;
	}
	public void setLeaveTime(int time){
		this.leaveTime = time;
	}
	
	public String getResultData(){
//		bw.write("���̵�,�̸�,�ν������ð�,��ǥ�ҿ�ð�,�̵��ҿ�ð�,��߿�,������,��ǥ���ð�,�������ð�,��߽ð�,�����ð�\n");
		return id+","+name+","+arrivedTime+","+ticketingTime+","+getTravelTime()+","
				+stationFrom+","+stationTo+","+getTicketingReady()+","+getTrainReady()+","+leaveTime+","+finalTime;
	}
	@Override
	public String toString() {
		return 	"   "+id +"\t"+ 
				name +"\t"+ 
				"  "+arrivedTime +"��\t"+ 
				"  "+ticketingTime +"��\t"+
				"  "+getTravelTime() +"��";
	}
	
	
}
