package evRentingPlatform;

import java.time.*;
/**
 * the data structure of the renting history
 * @author linchia-ho
 *
 */
public class RentHistory {
	/**
	 * the date, can only be set by constructor
	 */
	private LocalDate date;
	/**
	 * the rent fee
	 */
	private double rentFee;
	/**
	 * the position when renting happens, can only be set by constructor
	 */
	private Position startPosition;
	/**
	 * the position when renting ends
	 */
	private Position endPosition;
	/**
	 * the accumulate distance 
	 */
	private double distance;
	/**
	 * the time when renting starts, can only be set by constructor
	 */
	private LocalTime rentStartTime;
	/**
	 * the time when renting ends
	 */
	private LocalTime rentEndTime;
	/**
	 * the total renting time
	 */
	private Duration totalTime;
	/**
	 * amount of time that user charges the scooter at charging station
	 */
	private int chargeTimes;
	/**
	 * whether this transaction receive discount from valid coupon
	 */
	private boolean withCoupon;
	/**
	 * the serial number of the scooter
	 */
	private String scooterNo;
	
	//public RentHistory() {};
	public RentHistory(Position startPosition, String scooterNo) {
		this.date = LocalDate.now();
		this.startPosition = new Position(startPosition);
		this.rentStartTime = LocalTime.now();
		this.scooterNo = scooterNo;
	}	
	/**
	 * @return the scooterNo
	 */
	public String getScooterNo() {
		return scooterNo;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @return the rentFee
	 */
	public double getRentFee() {
		return rentFee;
	}
	/**
	 * @param rentFee the rentFee to set
	 */
	public void setRentFee(double rentFee) {
		this.rentFee = rentFee;
	}
	/**
	 * @param startPosition the startPosition to set
	 */
	public void setStartPosition(Position startPosition) {
		this.startPosition = startPosition;
	}
	/**
	 * @return the endPosition
	 */
	public Position getEndPosition() {
		return endPosition;
	}
	/**
	 * @param endPosition the endPosition to set
	 */
	public void setEndPosition(Position endPosition) {
		this.endPosition = endPosition;
	}
	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}
	/**
	 * @return the rentStartTime
	 */
	public LocalTime getRentStartTime() {
		return rentStartTime;
	}

	/**
	 * @return the rentEndTime
	 */
	public LocalTime getRentEndTime() {
		return rentEndTime;
	}
	/**
	 * @param rentEndTime the rentEndTime to set
	 */
	public void setRentEndTime(LocalTime rentEndTime) {
		this.rentEndTime = rentEndTime;
	}
	/**
	 * @return the totalTime
	 */
	public Duration getTotalTime() {
		return totalTime;
	}
	/**
	 * @param totalTime the totalTime to set
	 */
	public void setTotalTime(Duration totalTime) {
		this.totalTime = totalTime;
	}
	/**
	 * @return the chargeTimes
	 */
	public int getChargeTimes() {
		return chargeTimes;
	}
	/**
	 * @param chargeTimes the chargeTimes to set
	 */
	public void setChargeTimes(int chargeTimes) {
		this.chargeTimes = chargeTimes;
	}
	/**
	 * @return the withCoupon
	 */
	public boolean isWithCoupon() {
		return withCoupon;
	}
	/**
	 * @param withCoupon the withCoupon to set
	 */
	public void setWithCoupon(boolean withCoupon) {
		this.withCoupon = withCoupon;
	}
}
