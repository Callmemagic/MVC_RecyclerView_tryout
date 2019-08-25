package softmobile.com.mvctest.Bean;

/**
 * 實體類
 * 對數據的封裝
 */
public class Book {
    private String name; //書名
    private int img; //圖片

    public Book(String name, int img) {
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
