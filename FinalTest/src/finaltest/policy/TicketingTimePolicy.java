package finaltest.policy;

import finaltest.passenger.Passenger;

public class TicketingTimePolicy implements IPolicy{

	@Override
	public int compare(Passenger p1, Passenger p2) {
		return p1.getArrivalTime() - p2.getArrivalTime();
	}
}
