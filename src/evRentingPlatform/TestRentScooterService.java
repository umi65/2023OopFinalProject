package evRentingPlatform;

import java.util.ArrayList;

public class TestRentScooterService {

	public static void main(String[] args) {
		// New a service instance during the 
		RentScooterService service = new RentScooterService();
		// Login with a pre-created user account
		service.userLogIn("WeirdCoffeePerson", "HarioV60");
		// Return user current position
		Position userPosition = service.showUserPosition(service.getUserOperator());
		System.out.println("User latitude: " + userPosition.lat + " User longitude: " + userPosition.lng);
		// Search scooters within given range
		ArrayList<Scooter> scooterWithinRange = service.searchScooter(service.getUserOperator().getPosition(), 0.25);
		System.out.println("Scooters Within Range: " + scooterWithinRange.size());
		for(Scooter scooter: scooterWithinRange) {
			 System.out.println("No: " + scooter.getNo());
            System.out.println("Power: " + scooter.getPower());	                
            System.out.println("Latitude: " + scooter.getLat());
            System.out.println("Longitude: " + scooter.getLng());
            System.out.println("Status: " + scooter.getStatus());
            System.out.println();
		}
	}

}
