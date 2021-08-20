package app.model;

public class Shop {

    private int id;
    private String title;

    public Shop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
