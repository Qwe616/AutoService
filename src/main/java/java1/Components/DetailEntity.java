package java1.Components;


import java.util.ArrayList;

public class DetailEntity {
    private int id = 0;
    private String Name = null;
    private ArrayList<PropertyEntity> propertyEntity = new ArrayList<>();

    public String getName() {return Name;}

    public void setName(String name) {
        Name = name;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<PropertyEntity> getPropertyEntity() {
        return propertyEntity;
    }

    public void setPropertyEntity(ArrayList<PropertyEntity> propertyEntity) {
        this.propertyEntity = propertyEntity;
    }
    @Override
    public String toString() {
        return Name;
    }
}
