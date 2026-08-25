import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        // Step 4: add contacts here 
        contacts.put("Bibo", new Contact("Bibo", "7742665313"));
        contacts.put("Adam", new Contact("Adam", "1234567890"));
        contacts.put("Gaby", new Contact("Gaby", "0123456789"));
        contacts.put("Silvia", new Contact("Silvia", "4567890543"));
        contacts.put("Sara", new Contact("Sara", "9494948272"));
 
        // Step 5: look up a contact 
        find(contacts, "Bibo");
        find(contacts, "unknown");
 
        // Step 6: print sorted list 
        printSortedList(contacts);
    } 

    public static void find(HashMap<String, Contact> contacts, String name) {
        Contact found = contacts.get(name);
        if (found == null) {
            System.out.println("Contact {" + name + "} not found.");
        } else {
            System.out.println(found.toString());
        }
    }

    public static void printSortedList(HashMap<String, Contact> contacts) {
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        if(sorted.size() > 0) {
            System.out.println("=== All Contacts ===:");
        }
        for (Contact contact : sorted) {
            System.out.println(contact.toString());
        }
    }
}