package vn.edu.iuh.fit.www_lab_week2.models;

public class ProductImage {
    private long imageID;
    private String alternative;
    private String path;

    public ProductImage() {
    }

    public ProductImage(long imageID, String alternative, String path) {
        this.imageID = imageID;
        this.alternative = alternative;
        this.path = path;
    }

    public long getImageID() {
        return imageID;
    }

    public void setImageID(long imageID) {
        this.imageID = imageID;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
