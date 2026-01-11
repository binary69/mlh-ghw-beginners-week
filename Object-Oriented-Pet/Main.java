import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your pet's name: ");
        String name = sc.nextLine();

        Pet myPet = new Pet(name);

        boolean playing = true;

        while(playing){
            myPet.stats();

            System.out.println("1: Feed the pet \n2: Play with the pet\n3: Quit ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    myPet.feed();
                    break;
                case 2:
                    myPet.play();
                    break;
                case 3:
                    playing = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    myPet.passTime();
                    break;
            }
        }
        sc.close();
    }
}