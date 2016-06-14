package java1.Components;

import java.util.ArrayList;

public class AutoEntity {
    private int id;
    private String Name;
    private String Mark;
    private String Model;
    private ArrayList<DetailEntity> details = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<DetailEntity> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<DetailEntity> details) {
        this.details = details;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getMark() {
        return Mark;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(getClass() == obj.getClass()))
            return false;
        else {
            AutoEntity tmp = (AutoEntity) obj;
            if (tmp.id == this.id && tmp.getName() == this.getName() && tmp.getMark() == this.getMark() && tmp.getModel() == this.getModel())
                return true;
            else
                return false;
        }
    }
}

