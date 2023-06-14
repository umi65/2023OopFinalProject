package evRentingPlatform;

import evRentingPlatform.Scooter.ScooterStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
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
	private Repairman rpOperator = null;
	private User userOperator = null;//make sure always decouple after used, whether normally or abnormally ends
	/**
	 * @return the userOperator
	 */
	public User getUserOperator() {
		return userOperator;
	}
	/**
	 * @param userOperator the userOperator to set
	 */
	public void setUserOperator(User userOperator) {
		this.userOperator = userOperator;
	}
	
	/**
	 * Automatically loads in users, scooters, repairmen and charging stations 
	 */
	public RentScooterService() {
		// Share use a singleton ObjectMapper to increase efficiency
		ObjectMapper objectMapper = new ObjectMapper();
		this.initiateUser(objectMapper);
		this.initiateScooter(objectMapper);
		this.initiateChargingStation(objectMapper);
		this.initiateRepairman(objectMapper);
		//System.out.println(scooterList.size());
	}
	/**
	 * Initiate exist users: read external file and create {@code User} class respectively
	 * @param SingletonObjectMapper an reusable ObjectMapper instance
	 * @return {@code true} if successfully executed; otherwise {@code false}.
	 */
	private boolean initiateUser(ObjectMapper SingletonObjectMapper) {
		ObjectMapper objectMapper = SingletonObjectMapper;
		try {
            // Read the JSON file
            File file = new File("resources/user.json");
            
            // Map the JSON array to a list of Location objects
            this.userList = objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {});
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	/**
	 * Initiate exist scooters read external file and create {@code Scooter} class respectively.
	 * @param SingletonObjectMapper an reusable ObjectMapper instance
	 * @return {@code true} if successfully executed; otherwise {@code false}.
	 */
	private boolean  initiateScooter(ObjectMapper SingletonObjectMapper) {
		ObjectMapper objectMapper = SingletonObjectMapper;
		try {
            // Read the JSON file
			File file = new File("resources/scooter_detail.json");
            
            // Map the JSON array to a list of Location objects
            this.scooterList = objectMapper.readValue(file, new TypeReference<ArrayList<Scooter>>() {});
//            for (Scooter scooter : scooterList) {
//                System.out.println("No: " + scooter.getNo());
//   	          System.out.println("Power: " + scooter.getPower());	                
//                System.out.println("Latitude: " + scooter.getLat());
//                System.out.println("Longitude: " + scooter.getLng());
//                System.out.println();
//            }        
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	/**
	 * Initiate repairmans
	 * @param SingletonObjectMapper an reusable ObjectMapper instance	
	 * @return {@code true} if successfully executed; otherwise {@code false}.
	 */
	private boolean  initiateRepairman(ObjectMapper SingletonObjectMapper) {
		ObjectMapper objectMapper = SingletonObjectMapper;
		try {
            // Read the JSON file
            File file = new File("resources/repairman.json");
            
            // Map the JSON array to a list of Location objects
            this.repairmanList = objectMapper.readValue(file, new TypeReference<ArrayList<Repairman>>() {});
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	/**
	 * Initiate ChargingStations, read external file and create {@code ChargingStation} class respectively
	 * @param SingletonObjectMapper an reusable ObjectMapper instance
	 * @return 
	 */
	private boolean  initiateChargingStation(ObjectMapper SingletonObjectMapper) {
		ObjectMapper objectMapper = SingletonObjectMapper;
		try {
            // Read the JSON file
            File file = new File("resources/battery.json");
            
            // Map the JSON array to a list of Location objects
            this.chargingStationList = objectMapper.readValue(file, new TypeReference<ArrayList<ChargingStation>>() {});
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	/**
	 * input user's account and password, if valid, the user will be stored as operator
	 * @param account the account
	 * @param password the password
	 * @return {@code true} if successfully executed; otherwise {@code false}.
	 */
	public boolean userLogIn(String account, String password) {
		try {
			for(User user: userList){
				if(account.equals(user.getAccount()) && password.equals(user.getPassword())) {
					this.userOperator = user;
					this.userOperator.setInitialPosition();
					//System.out.println("Welcome User: " + userOperator.getAccount());
					return true;
				}
			}
			return false;
		}catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	/**
	 * input repairman's account and password, if valid, the repairman will be stored as UserOperator
	 * @param account the account
	 * @param password the password
	 * @return {@code true} if successfully executed; otherwise {@code false}.
	 */
	public boolean repairmanLogIn(String account, String password) {
		try {
			for(Repairman repairman: repairmanList){
				if(account.equals(repairman.getAccount()) && password.equals(repairman.getPassword())) {
					this.rpOperator = repairman;
					//System.out.println("Welcome Repairman: " + rpOperator.getAccount());
					return true;
				}
			}
			return false;
		}catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	/**
	 * Return user's position for GUI display
	 * use {@code Position.lat} and {@code Position.lng} to get latitude and longitude respectively
	 * @param user user who requires it's geography position
	 * @return user's position
	 */
	public Position showUserPosition(User user) {
		return user.getPosition();
	}
	/**
	 * serach available scooter in given range from user's current position
	 * @param position the user's current position
	 * @param diameter diameter of searching circle in Kilometer
	 * @return the list of scooters which are available in given range
	 */
	public ArrayList<Scooter> searchScooter(Position position, double diameter){
		try {
			double radius = diameter * 0.005;
			Double[] latLimit = {(position.lat - radius),(position.lat + radius)};
			Double[] lngLimit = {(position.lng - radius),(position.lng + radius)};
			ArrayList<Scooter> scooterWithinRange = new ArrayList<Scooter>(10);
			for(Scooter scooter: scooterList) {
				if(scooter.getLat() < latLimit[1] && scooter.getLat() > latLimit[0] &&
				   scooter.getLng() < lngLimit[1] && scooter.getLng() > lngLimit[0]) {
					if(scooter.getStatus() == Scooter.ScooterStatus.IDLE)
						scooterWithinRange.add(scooter);
				}
			}
			return scooterWithinRange;
		}catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<Scooter>(0);
		}
	}
	/**
	 * start renting the scooter, will trigger following actions:
	 * (1) store {@code Scooter} inside {@code User} to represent the action of renting a scooter, 
	 * (2) update user's position to scooter's position
	 * (3) Switch scooter's status to occupied
	 * (4) new a {@code RentHistory} to user
	 * @param user user who rents the scooter
	 * @param scooter the scooter been rent
	 * @return
	 */
	public boolean rentScooter(User user, Scooter scooter) {
		try {
			user.setScooter(scooter);
			user.setPosition(scooter.getPosition());
			scooter.setStatus(ScooterStatus.Occupied);
			user.newRentHistory();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
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
