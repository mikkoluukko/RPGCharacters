package items;

public abstract class Item {
    private ItemType itemType;
    private SlotType slotType;
    private String name;
    private int level;

    public Item(ItemType itemType, String name, int level, SlotType slotType) {
        setItemType(itemType);
        setSlotType(slotType);
        setName(name);
        setLevel(level);
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Item stats for: " + getName();
    }
}
