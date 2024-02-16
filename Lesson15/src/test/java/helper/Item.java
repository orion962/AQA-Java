package helper;

public class Item {
    private final String title;
    private final String price;

    public Item(String title, String price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        Item item = (Item) o;
        return (title.equals(item.title) && price.equals(item.price));
    }

    @Override
    public String toString() {
        return title + " " + price;
    }
}
