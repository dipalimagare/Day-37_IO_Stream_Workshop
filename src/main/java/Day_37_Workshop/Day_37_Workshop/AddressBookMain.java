package Day_37_Workshop.Day_37_Workshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMain {
	static Scanner sc = new Scanner(System.in);
	static LinkedList<Contact> contactDetailsList;

	private AddressBookMain() {
		contactDetailsList = new LinkedList<>();
	}

	private static void addContact(int addressBookNum) {
		System.out.print("Enter the number of entry in Address Book-" + addressBookNum + "::");
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

	private static void showContacts() {
		System.out.println("Displaying the contacts of contactPersons");
		List<Object> result = contactDetailsList.stream().collect(Collectors.toList());
		System.out.println(result);
	}

	private static void editContact(Map<String, AddressBookMain> addressBookMap) {
		sc.nextLine();
		System.out.println("First Name of the person whose record is to be edited: ");
		String firstName = sc.nextLine();
		System.out.println("Last Name of the person whose record is to be edited: ");
		String lastName = sc.nextLine();
		System.out.println("New Address: ");
		String address = sc.nextLine();
		System.out.println("New City: ");
		String city = sc.nextLine();
		System.out.println("New State: ");
		String state = sc.nextLine();
		System.out.println("New ZIP: ");
		int zip = sc.nextInt();
		System.out.println("New Phone No: ");
		long phoneNo = sc.nextLong();
		sc.nextLine();
		System.out.println("Edited Email ID: ");
		String emailId = sc.nextLine();
		for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
			AddressBookMain value = entry.getValue();
			for (int i = 0; i < value.contactDetailsList.size(); i++)
				if (value.contactDetailsList.get(i).firstName.equals(firstName)
						&& value.contactDetailsList.get(i).lastName.equals(lastName)) {
					Contact contactDetails = new Contact(city, state, emailId, address, lastName, zip, phoneNo,
							firstName);
					value.contactDetailsList.set(i, contactDetails);
					System.out.println("Edited the contact");
				}
		}
	}
	
	public static void deleteContactDetails(Map<String, AddressBookMain> addressBookMap) {
        sc.nextLine();
        System.out.println("Enter First Name of person whose record is to be deleted: ");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name of person whose record is to be deleted: ");
        String lastName = sc.nextLine();
        int flag = 0;
        for (Map.Entry<String, AddressBookMain> entry : addressBookMap.entrySet()) {
            AddressBookMain value = entry.getValue();
            for (int i = 0; i < value.contactDetailsList.size(); i++)
                if (value.contactDetailsList.get(i).firstName.equals(firstName)
                        && value.contactDetailsList.get(i).lastName.equals(lastName)) {
                    value.contactDetailsList.remove(i);
                    System.out.println("Deleted Contact");
                    flag = 1;
                }
        }
        if (flag == 0) {
            System.out.println("No such record found");
        }

    }
	private static void addingMultipleContacts(Map<String, AddressBookMain> addressBookMap) {
		System.out.println("Adding multiple contacts to addressbook");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter how many contacts do u want to add?");
		int numOfContacts = s.nextInt();
		for (int i = 1; i <= numOfContacts; i++) {
			AddressBookMain.addContact(numOfContacts);
		}

	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to Address Book Program in AddressBookMain class on Master Branch");
		AddressBookMain addressBook = new AddressBookMain();
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
			addressBookMap.put(addressBookName, addressBookArray[i]);
			
			showContacts();
		}
		int i = 1;
		while (i == 1) {
			System.out.println("Choose an option ");
			System.out.println("1. Edit Contact ");
			System.out.println("2. Delete Contact ");
			System.out.println("3. AddMultipleContact  Contact ");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				editContact(addressBookMap);
				break;
			case 2:
                deleteContactDetails(addressBookMap);
                break;
			case 3:
                addingMultipleContacts(addressBookMap);
                break;
			default:
				i = 0;
			}
		}
	}

}
