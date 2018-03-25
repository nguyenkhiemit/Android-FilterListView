package newgate.com.filterlistview;

/**
 * Created by apple on 3/25/18.
 */

public class Person {

    private String name;

    private int img;

    public Person(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
