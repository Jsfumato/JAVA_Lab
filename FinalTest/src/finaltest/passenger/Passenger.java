package finaltest.passenger;

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
	
//	������
	Passenger(String[] token){
		this.id = Integer.parseInt(token[0]);
		this.name = token[1];
		this.arrivedTime = Integer.parseInt(token[2]);
		this.ticketingTime = Integer.parseInt(token[3]);
		this.stationFrom = token[4];
		this.stationTo = token[5];
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
	
	public int getReadyTime(){
		return leaveTime - arrivedTime;
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
//		bw.write("���̵�,�̸�,�ν������ð�,��ǥ�ҿ�ð�,�̵��ҿ�ð�,��߿�,������,���ð�,��߽ð�,�����ð�\n");
		return id+","+name+","+arrivedTime+","+ticketingTime+","+getTravelTime()+","
				+stationFrom+","+stationTo+","+getReadyTime()+","+leaveTime+","+finalTime;
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
