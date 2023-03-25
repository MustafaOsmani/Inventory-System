public class Item {
    private ItemType type;
    private String name;
    private int weight;
    private int value;
    private int strength;

    public Item(ItemType type, String name, int weight, int value, int strength) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.strength = strength;
    }

    public ItemType getType() {return type;}

    public String getName() {return name;}

    public int getWeight() {return weight;}

    public int getValue() {return value;}

    public int getStrength() {return strength;}
}
