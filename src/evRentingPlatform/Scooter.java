package evRentingPlatform;

/**
 * the data structure of a scooter, which contains series number, position, battery, and status
 * @author linchia-ho
 *
 */
public class Scooter {
	/**
	 * 
	 * @author linchia-ho
	 *
	 */
	public enum ScooterStatus{
		/**
		 * ready for service
		 */
		IDLE,
		/**
		 * under use
		 */
		Occupied,
		/**
		 * cannot be used, should be fix by repairman
		 */
		Malfunction,
		/**
		 * under repairing
		 */
		Repairing
	}
	/**
	 * the series number of the scooter, read from given .json file
	 */
	private String no;
	/**
	 * the position of the scooter, read from given .json file
	 */
	private Position position;
	/**
	 * the status of the scooter
	 */
	private ScooterStatus status;
	/**
	 * the remaining battery
	 */
	private int power;
}
