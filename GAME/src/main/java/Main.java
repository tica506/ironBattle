import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Character> characters = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Create Warrior");
            System.out.println("2. Create Wizard");
            System.out.println("3. Battle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    createWarrior();
                    break;
                case 2:
                    createWizard();
                    break;
                case 3:
                    battle();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    private static void createWarrior() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        scanner.nextLine();  // consume newline

        Warrior warrior = new Warrior(name);
        characters.add(warrior);
        System.out.println("Warrior created: " + warrior);
    }

    private static void createWizard() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Wizard wizard = new Wizard(name);
        characters.add(wizard);
        System.out.println("Wizard created: " + wizard);
    }

    private static void battle() {
        if (characters.size() < 2) {
            System.out.println("Need at least two characters to battle.");
            return;
        }

        Character char1 = chooseCharacter("Choose first character for battle: ");
        Character char2 = chooseCharacter("Choose second character for battle: ");

        System.out.println("Battle between " + char1.getName() + " and " + char2.getName());
        while (char1.isAlive() && char2.isAlive()) {
            char1.attack(char2);
            if (char2.isAlive()) {
                char2.attack(char1);
            }
        }

        if (char1.isAlive()) {
            System.out.println(char1.getName() + " wins!");
        } else {
            System.out.println(char2.getName() + " wins!");
        }
    }

    private static Character chooseCharacter(String prompt) {
        System.out.println(prompt);
        for (int i = 0; i < characters.size(); i++) {
            System.out.println((i + 1) + ". " + characters.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline
        return characters.get(choice - 1);
    }
}

