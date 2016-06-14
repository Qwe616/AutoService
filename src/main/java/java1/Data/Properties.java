package java1.Data;

import java1.Components.AutoEntity;
import java1.Components.DetailEntity;
import java1.Components.PropertyEntity;
import java1.DBWorked;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Properties {
    private ArrayList<PropertyEntity> properties = new ArrayList<>();
    private DBWorked con = new DBWorked();
    
    private Properties()
    {
        SelectProperties();
    }
    private void SelectProperties()
    {
        try {
            Statement statement = con.getConnection().createStatement();
            String select = "SELECT * FROM AutoService.dbo.Properties";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next())
            {
                PropertyEntity propertyEntity = new PropertyEntity();
                propertyEntity.setId(resultSet.getInt(1));
                propertyEntity.setName(resultSet.getString(2));
                properties.add(propertyEntity);
            }
            con.getConnection().isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ArrayList<PropertyEntity> getAll() {return properties;}
    
    public void addPropertyList(PropertyEntity propertyEntity) {
        try {
            String insertTempl = "INSERT INTO AutoService.dbo.Properties(Name)VALUES ('%s')";
            String insert = String.format(insertTempl, propertyEntity.getName());
            Statement statement = con.getConnection().createStatement();
            statement.execute(insert);
            String selectPropertyDetailAuto = "SELECT id FROM AutoService.dbo.Properties WHERE Name = '%s'";
            String select = String.format(selectPropertyDetailAuto, propertyEntity.getName());
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next())
            {
                propertyEntity.setId(resultSet.getInt(1));
                properties.add(propertyEntity);
                con.getConnection().isClosed();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addPropertyDetail (AutoEntity car, DetailEntity detail, PropertyEntity propertyEntity)
    {
        try {
            String Value= JOptionPane.showInputDialog(null,"Введите значение свойства","Значение",
                    JOptionPane.INFORMATION_MESSAGE);
            String getInsertPropertyDetail = "INSERT INTO AutoService.dbo.AutoDetailsProperties " +
                    "(Auto_id, Details_id, Properties_id, [Values]) VALUES ('%s','%s','%s','%s')";
            String insert = String.format(getInsertPropertyDetail,car.getId(),detail.getId(), propertyEntity.getId(),Value);
            Statement statement = con.getConnection().createStatement();
            statement.execute(insert);
            con.getConnection().isClosed();
            propertyEntity.setValue(Value);
            detail.getPropertyEntity().add(propertyEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public PropertyEntity bustPropertyInList(String NameProperty)
    {
        PropertyEntity propertyEntity = null;
        for (PropertyEntity propertyEntity1 : properties) {
            if (NameProperty.toUpperCase().trim().equals(propertyEntity1.getName().toUpperCase())) {
                propertyEntity = propertyEntity1;
                break;
            }
        }
        return propertyEntity;
    }
    public PropertyEntity bustPropertyDetailCar(DetailEntity detail, String NameProperty)
    {
        PropertyEntity propertyEntity = null;
        for(int i = 0; i<detail.getPropertyEntity().size(); i++) {
            if(NameProperty.toUpperCase().trim().equals(detail.getPropertyEntity().get(i).getName().toUpperCase())) {
                propertyEntity = detail.getPropertyEntity().get(i);
                break;
            }
        }
        return propertyEntity;
    }
    public void deleteProperty (DetailEntity detailEntity, Object Property)
    {   PropertyEntity propertyEntity;
        for(int i = 0; i< detailEntity.getPropertyEntity().size(); i++ ) {
            if(Property.equals(detailEntity.getPropertyEntity().get(i).getName())) {
                propertyEntity = detailEntity.getPropertyEntity().get(i);
                try {
                    Statement statement = con.getConnection().createStatement();
                    String deletePropertyDetail = "DELETE  FROM AutoService.dbo.AutoDetailsProperties " +
                                                  "WHERE Details_id = %s AND Properties_id = %s";
                    String delete = String.format(deletePropertyDetail, detailEntity.getId(), propertyEntity.getId());
                    statement.executeUpdate(delete);
                    con.getConnection().isClosed();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                detailEntity.getPropertyEntity().remove(detailEntity.getPropertyEntity().get(i));
            }
        }
    }
    public void updateProperty(AutoEntity autoEntity, DetailEntity detailEntity, int q, String Value)
    {
        try {
            Statement statement = con.getConnection().createStatement();
            String updatePropertyDetail = "UPDATE AutoService.dbo.AutoDetailsProperties SET [Values] = '%s' " +
                                          "WHERE Auto_id = %s AND Details_id = %s AND Properties_id = %s";
            String update = String.format(updatePropertyDetail,Value,
                    autoEntity.getId(), detailEntity.getId(), detailEntity.getPropertyEntity().get(q).getId());
            statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        detailEntity.getPropertyEntity().get(q).setValue(Value);
    }
    private static Properties getInstance;
    public static Properties getInstance(){
        if (getInstance == null){
            getInstance = new Properties();
            return getInstance;
        }else
            return getInstance;
    }
}