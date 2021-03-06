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
	
//	생성자
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
//		bw.write("아이디,이름,부스도착시간,매표소요시간,이동소요시간,출발역,도착역,매표대기시간,열차대기시간,출발시간,도착시간\n");
		return id+","+name+","+arrivedTime+","+ticketingTime+","+getTravelTime()+","
				+stationFrom+","+stationTo+","+getTicketingReady()+","+getTrainReady()+","+leaveTime+","+finalTime;
	}
	@Override
	public String toString() {
		return 	"   "+id +"\t"+ 
				name +"\t"+ 
				"  "+arrivedTime +"분\t"+ 
				"  "+ticketingTime +"분\t"+
				"  "+getTravelTime() +"분";
	}
	
	
}
