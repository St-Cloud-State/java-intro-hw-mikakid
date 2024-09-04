import java.io.*;
import java.util.LinkedList;

public class PersonList {
    private LinkedList<Person> list;

    //constructor
    public PersonList() {
        list = new LinkedList<>();
    }

    // Method to store Person data from the input stream to the list
    public void store(BufferedReader input) throws IOException {
        String line;
        while ((line = input.readLine()) != null) {
            String[] personData = line.split(" ");
            if (personData.length == 3) {
                Person person = new Person(personData[0], personData[1], personData[2]);
                list.add(person);
            }
        }
    }

    // Method to display all Person objects in the list
    public void display(PrintStream output) {
        for (Person person : list) {
            output.println(person.toString());
        }
    }

    // Method to find a Person by ID in the list
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;  // Return the index if found
            }
        }
        return -1;  // Return -1 if not found
    }

    // Method to get a Person by index
    public Person get(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            return null; // Return null if the index is out of bounds
        }
    }
}
