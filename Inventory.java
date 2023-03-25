import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private ArrayList<Item> items;
    private int maxWeight;
    private Item equippedWeapon;
    private Item equippedArmor;

    public Inventory(int maxWeight) {
        this.maxWeight = maxWeight;
        this.equippedWeapon = null;
        this.equippedArmor = null;
        items = new ArrayList<>();
    }

    public int totalWeight(ArrayList<Item> pound) {
        int totalPounds = 0;
        for (int i = 0; i < pound.size(); i++) {
            totalPounds += pound.get(i).getWeight();
        }
        return totalPounds;
    }

    public boolean add(Item x) {
        if ((totalWeight(items) + x.getWeight()) <= maxWeight) {
            items.add(x);
            System.out.println("The " + x.getName() + " was added to your inventory.");
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        String titleTemplate = "%-25s %-25s %-25s %-25s%n";
        String template = "%-25s %-25d %-25s %-25s%n";
        //title
        System.out.printf(titleTemplate, "Item", "Weight", "Value", "Strength");
        //details
        for (int i = 0; i < items.size(); i++) {
            if(equippedWeapon == items.get(i)) {
                System.out.printf(template, items.get(i).getName(), items.get(i).getWeight(),
                        items.get(i).getValue(), items.get(i).getStrength());
                System.out.print(" (equipped weapon)");
            } else if (equippedArmor==items.get(i)) {
                System.out.printf(template, items.get(i).getName(), items.get(i).getWeight(),
                        items.get(i).getValue(), items.get(i).getStrength());
                System.out.print(" (equipped armor)");
            }else {
                System.out.printf(template, items.get(i).getName(), items.get(i).getWeight(),
                        items.get(i).getValue(), items.get(i).getStrength());
            }
        }
    }

    public void drop() {
        Scanner in = new Scanner(System.in);
        System.out.println("Drop an item");
        String titleTemplate = "%-25s %-25s %-25s %-25s%n";
        String template = "%-25s %-25d %-25s %-25s%n";
        //title
        System.out.printf(titleTemplate, "Item", "Weight", "Value", "Strength");
        //details
        int num = 0;
        for (int i = 0; i < items.size(); i++) {
            num = i + 1;
            System.out.printf(template, num + ".\t" + items.get(i).getName(), items.get(i).getWeight(),
                    items.get(i).getValue(), items.get(i).getStrength());
        }
        int cancel = num + 1;
        System.out.printf(cancel + ". Cancel");
        System.out.println();
        System.out.print(": ");
        int decide = in.nextInt();
        if (decide == cancel) {
            return;
        } else {
            Item removed = items.get(decide - 1);
            System.out.println("You dropped the " + removed.getName());
            items.remove(removed);
        }
    }

    public void equipWeapon() {
        System.out.println("Equip a Weapon");
        Scanner in = new Scanner(System.in);
        String titleTemplate = "%-25s %-25s %-25s %-25s%n";
        String template = "%-25s %-25d %-25s %-25s%n";
        //title
        System.out.printf(titleTemplate, "Item", "Weight", "Value", "Strength");
        int list = 0;
        ArrayList<Item> weapon = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType().equals(ItemType.WEAPON)) {
                list +=1;
                System.out.printf(template, list + ".\t" + items.get(i).getName(), items.get(i).getWeight(),
                        items.get(i).getValue(), items.get(i).getStrength());
                weapon.add(items.get(i));
            }
        }
        int cancel = list + 1;
        System.out.printf(cancel + ". Cancel");
        System.out.println();
        System.out.print(": ");
        int decide = in.nextInt();
        if (decide == cancel) {
            return;
        } else {
            Item chosen = weapon.get(decide - 1);
            System.out.println("You equipped the " + chosen.getName());
            equippedWeapon = chosen;
        }
    }
    public void equipArmor() {
        System.out.println("Equip Armor");
        Scanner in = new Scanner(System.in);
        String titleTemplate = "%-25s %-25s %-25s %-25s%n";
        String template = "%-25s %-25d %-25s %-25s%n";
        //title
        System.out.printf(titleTemplate, "Item", "Weight", "Value", "Strength");
        int list = 0;
        ArrayList<Item> armor = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getType().equals(ItemType.ARMOR)) {
                list +=1;
                System.out.printf(template, list + ".\t" + items.get(i).getName(), items.get(i).getWeight(),
                        items.get(i).getValue(), items.get(i).getStrength());
                armor.add(items.get(i));
            }
        }
        int cancel = list + 1;
        System.out.printf(cancel + ". Cancel");
        System.out.println();
        System.out.print(": ");
        int decide = in.nextInt();
        if (decide == cancel) {
            return;
        } else {
            Item chosen = armor.get(decide - 1);
            System.out.println("You equipped the " + chosen.getName());
            equippedArmor = chosen;
        }
    }
}

