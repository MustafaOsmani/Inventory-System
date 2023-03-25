import java.util.Random;

public class ItemGenerator {

    public static Item generate() {
        String title;
        int pounds;
        int cost;
        int power;
        Random rand = new Random();
        switch (rand.nextInt(3) + 1) {
            case 1:
                ItemType def = ItemType.ARMOR;
                pounds = (rand.nextInt(10) + 11);
                cost = (rand.nextInt(25) + 6);
                power = (rand.nextInt(45) + 5);
                //name
                if ((cost >= 20) && (power >= 40)) {
                    title = ("Legendary Armor of Wrath");
                } else if (power >= 40) {
                    title = ("Deflector of Lightning Armor");
                } else if (cost >= 20) {
                    title = ("Gold Plated Armor");
                } else {
                    title = ("Cracked Silver Armor");
                }
                Item thing = new Item(def, title, pounds, cost, power);
                return thing;
            case 2:
                def = ItemType.WEAPON;
                pounds = (rand.nextInt(10) + 11);
                cost = (rand.nextInt(25) + 6);
                power = (rand.nextInt(55) + 5);
                //name
                if ((cost >= 20) && (power >= 40)) {
                    title = ("HellBringer Sword of Death");
                } else if (power >= 40) {
                    title = ("Heart Piercer Spear");
                } else if (cost >= 20) {
                    title = ("Diamond Sword");
                } else {
                    title = ("Cracked Copper Sword");
                }
                thing = new Item(def, title, pounds, cost, power);
                return thing;
            case 3:
                def = ItemType.OTHER;
                pounds = (rand.nextInt(10));
                cost = (rand.nextInt(25));
                power = (0);
                //name
                if ((cost >= 20) && (pounds >= 7)) {
                    title = ("Dragon Egg");
                } else if (cost >= 20) {
                    title = ("Pouch of Gold");
                } else if (cost >= 10) {
                    title = ("Silver Coins");
                } else if (cost >= 5) {
                    title = ("Homemade Doll");
                } else {
                    title = ("Healing Flower");
                }
                thing = new Item(def, title, pounds, cost, power);
                return thing;
        }
        return null;
    }

}
