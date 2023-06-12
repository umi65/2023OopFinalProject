package evRentingPlatform;

import java.util.ArrayList;

/**
 * the instance of the scooter renting service and contains interactive actions
 * @author linchia-ho
 *
 */
public class RentScooterService {
	private ArrayList<User> userList;
	private ArrayList<Scooter> scooterList;
	private ArrayList<Repairman> repairmanList;
	private ArrayList<ChargingStation> chargingStationList;
	
	/**
	 * Automatically loads in users, scooters, repairmen and charging stations 
	 */
	public RentScooterService() {
		this.initiateUser();
		this.initiateScooter();
		this.initiateChargingStation();
		this.initiateRepairman();
	}
	/**
	 * Initiate exist users: read external file and create {@Code User} class respectively
	 */
	private void initiateUser() {
		
	}
	/**
	 * Initiate exist Scooters read external file and create {@Code Scooter} class respectively
	 */
	private void  initiateScooter() {
		
	}
	/**
	 * Initiate repairmans
	 */
	private void  initiateRepairman() {
		
	}
	/**
	 * Initiate ChargingStations, read external file and create {@Code ChargingStation} class respectively
	 */
	private void  initiateChargingStation() {
		
	}
	/**
	 * Return user's position for GUI display
	 * @param user user who requires it's geography position
	 * @return user's position
	 */
	public Position showUserPosition(User user) {
		return null;
	}
	/**
	 * serach available scooter in given range from user's current position
	 * @param position the user's current position
	 * @param range range of searching distance in Kilometer
	 * @return the list of scooters which are available in given range
	 */
	public ArrayList<Scooter> searchScooter(Position position, double range){
		return null;
	}
	/**
	 * store Scooter inside user to represent the action of renting a scooter
	 * @param user user who rents the scooter
	 * @param scooter the scooter been rent
	 * @return
	 */
	public boolean rentScooter(User user, Scooter scooter) {
		return false;
	}
	/**
	 * start riding scooter, the position will be updated and recorded to the rentHistory
	 * @param user target user
	 * @return {@code true} if successfully executed; otherwise {@code false}
	 */
	public boolean rideScooter(User user) {
		return false;
	}
	/**
	 * temporarily stop updating position and recording rentHistory 
	 * @param user target user
	 * @return {@code true} if successfully executed; otherwise {@code false}
	 */
	public boolean stopRidingScooter(User user) {
		return false;
	}
	/**
	 * search charging stations within default distance from the user's current position
	 * @param position current user position
	 * @return the list of ChargingStation within default distance
	 */
	public ArrayList<ChargingStation> searchChargingStation(Position position){
		return null;
	}
	/**
	 * move to the selected charging station, if the remain battery is not enough, this action will not be executed
	 * @param user target user
	 * @param chargingStation target charging station
	 * @return {@code true} if successfully executed; otherwise {@code false}
	 */
	public boolean moveToChargingStation(User user, ChargingStation chargingStation) {
		return false;
	}
	/**
	 * rewrite scooter's battery to 100
	 * @param user user who execute charging
	 * @return {@code true} if successfully executed; otherwise {@code false}
	 */
	public boolean chargeScooter(User user){
		return false;
	}
	/**
	 * terminate a ride, the position will stop updating and rentHistory will no longer be record
	 * @param user target user
	 * @return {@code true} if successfully executed; otherwise {@code false}
	 */
	public boolean endRidingScooter(User user) {
		return false;
	}
	/**
	 * return display Position and distance for GUI display
	 * @param user target user
	 * @return [latitude, longitude, distance]
	 */
	public double[] displayPositionAndDistance(User user) {
		return null;
	}
	/**
	 * return the fee of the current ride for GUI display
	 * @param user target
	 * @return the value of fee
	 */
	public double displayFee(User user) {
		return 0.0;
	}
	/**
	 * execute payment and decouple the scooter from the user
	 * @param user target user
	 * @param withCoupon {@code true} if use coupon for this ride; otherwise {@code false}
	 * @return {@code true} if successfully executed; otherwise {@code false}
	 */
	public boolean payFeeAndReturnScooter(User user, boolean withCoupon) {
		return false;
	}
	/**
	 * search for malfunction scooters
	 * @param repairman repairman who execute searching
	 * @return the list of all malfunction scooters
	 */
	public ArrayList<Scooter> searchMalfunctionScooter(Repairman repairman){
		return null;
	}
	/**
	 * fixes a scooter, will switch the status of a scooter from {@code Malfunction} to {@code IDLE}.
	 * @param repairmanm repairman who execute the fixing
	 * @param scooter the scooter to be fixed
	 * @return {@code true} if successfully executed; otherwise {@code false}
	 */
	public boolean fixScooter(Repairman repairmanm, Scooter scooter) {
		return false;	
	}
	/**
	 * charge a scooter. Then relocate the scooter to a different position
	 * @param repairman
	 * @return
	 */
	public boolean chargeLowBatteryScooter(Repairman repairman, Scooter scooter) {
		return false;
	}
	
	}
