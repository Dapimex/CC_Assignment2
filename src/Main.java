import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String input = getInput();
        Relation relation = new Relation(input);
        System.out.println(relation.parse());
        return;
    }

    private static String getInput() throws FileNotFoundException {
        File inputFile = new File("./input.txt");
        Scanner sc = new Scanner(inputFile);
        String input = sc.nextLine();
        return input; // create an input method
    }

}
