package items;

public abstract class Item {
    protected ItemType itemType;
    protected SlotType slotType;
    protected String name;
    protected int level;

    public Item(ItemType itemType, String name, int level) {
        this.itemType = itemType;
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    @Override
    public String toString() {
        return "Item stats for: " + name;
    }
}
