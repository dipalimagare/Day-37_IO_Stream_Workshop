package Day_37_Workshop.Day_37_Workshop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	private LinkedList<Contact> contactDetailsList;

	private AddressBookMain() {
		contactDetailsList = new LinkedList<>();
	}

	private void addContact(int addressBookNum) {
		System.out.print("Enter the number of entry in Address Book-" + addressBookNum +"::");
		int numOfEntries = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numOfEntries; i++) {
			String firstName, lastName;
			int flag = 0;
			do {
				int counter = 0;
				System.out.println("First Name: ");
				firstName = sc.nextLine();
				System.out.println("Last Name: ");
				lastName = sc.nextLine();
				final String first = firstName;
				final String last = lastName;
				if (contactDetailsList.stream().anyMatch(n -> n.getFirstName().equals(first))
						&& contactDetailsList.stream().anyMatch(n -> n.getLastName().equals(last))) {
					counter++;
				}
				if (counter != 0) {
					System.out.println("This name already exists! Please enter again");
					flag = 0;
				} else
					flag = 1;
			} while (flag == 0);
			System.out.println("Address: ");
			String address = sc.nextLine();
			System.out.println("City: ");
			String city = sc.nextLine();
			System.out.println("State: ");
			String state = sc.nextLine();
			System.out.println("ZIP: ");
			int zip = sc.nextInt();
			System.out.println("Phone No: ");
			long phoneNo = sc.nextLong();
			sc.nextLine();
			System.out.println("Email ID: ");
			String emailId = sc.nextLine();
			Contact contactDetail = new Contact(city, state, emailId, address, lastName, zip, phoneNo, firstName);
			contactDetailsList.add(contactDetail);
		}
		System.out.println("Contact added Successfully!!!!!");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program in AddressBookMain class on Master Branch");
		Map<String, AddressBookMain> addressBookMap = new HashMap<>();
        System.out.println("How many address books should be created? ");
        int noOfAddressBooks = sc.nextInt();
        sc.nextLine();
        AddressBookMain[] addressBookArray = new AddressBookMain[noOfAddressBooks];
        for (int i = 0; i < noOfAddressBooks; i++) {
            System.out.println("Enter name for Address Book " + (i + 1) + ": ");
            String addressBookName = sc.nextLine();
            addressBookArray[i] = new AddressBookMain();
            addressBookArray[i].addContact(i + 1);
//            addressBookMap.put(addressBookName, addressBookArray[i]);
            
          
        }
        
	}

}
