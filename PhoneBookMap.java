/*Given  names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers. You will then be given an unknown number of names to query your phone book for. For each  queried, print the associated entry from your phone book on a new line in the form name=phoneNumber; if an entry for  is not found, print Not found instead.
*/

/*
Sample input:
3
sam 99912222
tom 11122222
harry 12299933
sam
edward
harry
*/

/*
Sample output:
sam=99912222
Not found
harry=12299933
*/
import java.util.*;

public class PhoneBookMap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of entries
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character
        
        // Initialize the phone book (HashMap)
        Map<String, String> phoneBook = new HashMap<>();        
        // Populate the phone book
        for (int i = 0; i < n; i++) {
            String entry = scanner.nextLine();
            String[] parts = entry.split(" ");
            String name = parts[0];
            String phoneNumber = parts[1];
            phoneBook.put(name, phoneNumber);
        }
        
        // Process queries
        while (scanner.hasNext()) {
            String query = scanner.nextLine();
            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }
        
        scanner.close(); // Close the scanner
    }
}
