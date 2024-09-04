import java.io.*;

public class MyMainQ3 {
    public static void main(String[] args) {
        try {
            // Create a PersonList object
            PersonList personList = new PersonList();

            // Create input stream to read from a file
            FileReader fileReader = new FileReader("personData.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Call store() method to read data and store it in the PersonList
            personList.store(bufferedReader);

            // Display the contents of the PersonList
            personList.display(System.out);

            // Call find() method with a specific ID
            System.out.println("\nFinding person with ID 12345:");
            int index = personList.find("12345");
            if (index != -1) {
                System.out.println("Person found at index: " + index);
                Person person = personList.get(index); // Use get method to retrieve the person
                if (person != null) {
                    System.out.println(person);
                } else {
                    System.out.println("Person object is null");
                }
            } else {
                System.out.println("Person not found");
            }

            // Close the file reader
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
