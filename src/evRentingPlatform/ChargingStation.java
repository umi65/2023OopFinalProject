package evRentingPlatform;
/**
 * the instance of charging station, comprise of series number, latitude and longitude
 * @author linchia-ho
 *
 */
public class ChargingStation {
	/**
	 * the series number of the charging station; read from given .json file
	 */
	private int no;
	/**
	 * the position of the charging station; read from given .json file
	 */
	private Position position;
	
	/**
	 * 
	 * @param no the series number
	 * @param lat the latitude of the position
	 * @param lng the longitude of the postition
	 */
	public ChargingStation(int no, double lat, double lng) {
		this.no = no;
		this.position.lat = lat;
		this.position.lng = lng;
	}
	/**
	 * return a copy of it's position
	 * @return position
	 */
	public Position getPosition() {
		return new Position(this.position.getLat(), this.position.getLng());
	}
}
