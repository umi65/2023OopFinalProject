package evRentingPlatform;

import java.util.ArrayList;
/**
 * the customer of the scooter renting service
 * @author linchia-ho
 *
 */
public class User extends Person{
	
	private String cellphone;
	private String email;
	private String userName;
	private String creditCard;
	private ArrayList<RentHistory> rentHistory;
	private Scooter scooter;
	private ArrayList<Coupon> coupon;
	
	public User(String account, String password) {
		super(account, password);
		// TODO Auto-generated constructor stub
	}
	
}
