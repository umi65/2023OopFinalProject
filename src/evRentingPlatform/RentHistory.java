package evRentingPlatform;

import java.time.*;
/**
 * the data structure of the renting history
 * @author linchia-ho
 *
 */
public class RentHistory {
	
	private LocalDate date;
	private double rentFee;
	private Position startPosition;
	private Position endPosition;
	private double distance;
	private LocalTime rentStartTime;
	private LocalTime rentEndTime;
	private Duration totalTime;
	private int chargeTimes;
	private boolean withCoupon;
}
