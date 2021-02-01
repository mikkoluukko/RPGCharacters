package items;

// Item is implemented as an interface to make it easier to extend the code to include new item types
// that might differ a lot from the current item types in execution. At least currently different
// item types don't share a lot of variables or methods.
public interface Item {
    public String getName();
    public int getLevel();
    public String getItemType();
    public String getSlotType();
}
