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
	 * initiate a position data structure
	 * @param lat latitude
	 * @param lng longitude
	 */
	public Position(double lat, double lng) {
		super();
		setLat(lat);
		setLng(lng);
	}
	
	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public double getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}
	
}
