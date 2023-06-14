package evRentingPlatform;

public class Position {
	/**
	 * latitude
	 */
	public double lat;
	/**
	 * longitude
	 */
	public double lng;
	
	/**
	 * regular constructor for creating a position data structure with given latitude and longitude
	 * @param lat latitude
	 * @param lng longitude
	 */
	public Position(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	/**
	 * Copy constructor
	 * @param copyPosition
	 */
	public Position(Position copyPosition) {
		this.lat = copyPosition.lat;
		this.lng = copyPosition.lng;
	}
	/**
	 * empty constructor sets both latitude and longitude at -1000.0 to distinguish from normal value
	 */
	public Position() {
		this.lat = -1000.0;
		this.lng = -1000.0;
	}
}
