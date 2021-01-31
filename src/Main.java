import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    Logic logic = new Logic();
        UserInterface ui = new UserInterface(scanner, logic);
        ui.runUserInterface();
    }
}
