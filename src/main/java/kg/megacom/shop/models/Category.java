package kg.megacom.shop.models;

import java.util.Date;

public class Category {
    private int id;
    private String name;
    private boolean isActive;
    private Date createdDate;

    public Category(int id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.createdDate = new Date();
    }

    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return getName();
    }
}
