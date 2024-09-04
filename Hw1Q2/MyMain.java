import java.io.*;
import java.util.LinkedList;

public class MyMain {

    public static void main(String[] args) throws IOException {
        // Create a linked list to hold Person objects
        LinkedList<Person> personList = new LinkedList<>();

        // Create input stream to read from a file
        FileReader fileReader = new FileReader("personData.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Call store()
        store(bufferedReader, personList);

        // Display the contents of the linked list
        display(System.out, personList);

        // Call find() method with a specific ID
        System.out.println("\nFinding person with ID 12345:");
        int index = find("12345", personList);
        if (index != -1) {
            System.out.println("Person found at index: " + index);
            System.out.println(personList.get(index));
        } else {
            System.out.println("Person not found");
        }

        bufferedReader.close();
    }

    // Method to store
    public static void store(BufferedReader input, LinkedList<Person> list) throws IOException {
        String line;
        while ((line = input.readLine()) != null) {
            String[] personData = line.split(" ");
            if (personData.length == 3) {
                Person person = new Person(personData[0], personData[1], personData[2]);
                list.add(person);
            }
        }
    }

    // Method to display
    public static void display(PrintStream output, LinkedList<Person> list) {
        for (Person person : list) {
            output.println(person.toString());
        }
    }

    // Method to find a Person by ID in the linked list
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;  // Return the index if found
            }
        }
        return -1;  // Return -1 if not found
    }
}
