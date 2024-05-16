package ntou.springboot.practice.exercise5.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Sight")
public class Sight implements java.io.Serializable {
    private String id;
    private String sightName = null;
    private String zone = null;
    private String category = null;
    private String photoURL = null;
    private String description = null;
    private String address = null;

    public Sight() {
    }

    public Sight(String sightName, String zone, String category, String photoURL, String description, String address) {
        this.sightName = sightName;
        this.zone = zone;
        this.category = category;
        this.photoURL = photoURL;
        this.description = description;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getSightName() {
        return sightName;
    }

    public String getZone() {
        return zone;
    }

    public String getCategory() {
        return category;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("SightName: %s%nZone: %s%nCategory: %s%nPhotoURL:%n%s%nDescription: %s%nAddress: %s%n", getSightName(), getZone(), getCategory(), getPhotoURL(), getDescription(), getAddress());
    }
}
