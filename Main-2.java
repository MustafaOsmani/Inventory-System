import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Inventory play = new Inventory(60);
        int choice = 0;
        while(choice != 6){
            System.out.println("--------------------");
            System.out.println(1 + ".\t" + "Print inventory");
            System.out.println(2 + ".\t" + "Add random item");
            System.out.println(3 + ".\t" + "Drop item");
            System.out.println(4 + ".\t" + "Equip Weapon");
            System.out.println(5 + ".\t" + "Equip Armor");
            System.out.println(6 + ".\t" + "Exit");
            System.out.print(": ");
            choice = in.nextInt();
            if (choice == 1){
                play.print();
            } else if (choice==2) {
                Item creation = ItemGenerator.generate();
                play.add(creation);
            } else if (choice==3) {
                play.drop();
            } else if (choice==4) {
                play.equipWeapon();
            } else if (choice==5) {
                play.equipArmor();
            }
        }

    }
}
