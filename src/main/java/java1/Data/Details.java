package java1.Data;

import java1.Components.AutoEntity;
import java1.Components.DetailEntity;
import java1.Components.PropertyEntity;
import java1.DBWorked;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Details {
    private ArrayList<DetailEntity> details = new ArrayList<>();
    private DBWorked con = new DBWorked();
    private static Details getInstance;

    private Details()
    {
        SelectDetails();
    }

    private void SelectDetails()
    {
        try {
            Statement statement = con.getConnection().createStatement();
            String select = "SELECT * FROM AutoService.dbo.Details";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next())
            {
                DetailEntity detail = new DetailEntity();
                detail.setId(resultSet.getInt(1));
                detail.setName(resultSet.getString(2));
                details.add(detail);
            }
            con.getConnection().isClosed();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDetail(DetailEntity detail) {

        try {
            String insertTempl = "INSERT INTO AutoService.dbo.Details(Name) VALUES ('%s')";
            String insert = String .format(insertTempl,detail.getName());
            Statement statement = con.getConnection().createStatement();
            statement.execute(insert);
            String selectDetailAuto = "SELECT id FROM AutoService.dbo.Details WHERE Name = '%s'";
            String select = String.format(selectDetailAuto,detail.getName());
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next())
            {
                detail.setId(resultSet.getInt(1));
                details.add(detail);
            }
            con.getConnection().isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDetailsCar(AutoEntity autoEntity, DetailEntity detailEntity)
    {
        try {
            PropertyEntity thisPropertyEntity = new PropertyEntity();
            String Value = JOptionPane.showInputDialog
                    (null,"Введите материал из которого сделанна деталь","Первоначальное свойство",
                            JOptionPane.INFORMATION_MESSAGE);
            String getInsertTemplDetailCar = "INSERT INTO AutoService.dbo.AutoDetailsProperties " +
                    "(Auto_id, Details_id, Properties_id, [Values]) VALUES ('%s','%s',2,'%s')";
            String insert = String.format(getInsertTemplDetailCar, autoEntity.getId(), detailEntity.getId(),Value);
            Statement statement = con.getConnection().createStatement();
            statement.execute(insert);
            con.getConnection().isClosed();
            List<PropertyEntity> properties = java1.Data.Properties.getInstance().getAll();
            PropertyEntity propertyEntity = properties.get(1);
            thisPropertyEntity.setName(propertyEntity.getName());
            thisPropertyEntity.setValue(Value);
            detailEntity.getPropertyEntity().add(thisPropertyEntity);
            autoEntity.getDetails().add(detailEntity);
            }
        catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public  void deleteDetailCar(AutoEntity autoEntity, DetailEntity detailEntity)
    {
        autoEntity.getDetails().remove(detailEntity);
        try {
            String deleteAutoDetail = "DELETE FROM AutoService.dbo.AutoDetailsProperties " +
                    "                          WHERE Details_id = %s AND Auto_id = %s";
            String delete = String.format(deleteAutoDetail, detailEntity.getId(), autoEntity.getId());
            Statement statement = con.getConnection().createStatement();
            statement.executeUpdate(delete);
            con.getConnection().isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //todo переимновать
    public DetailEntity bustDetailCar(AutoEntity car, String NameDetail)
    {
        DetailEntity detailEntity = null;
        for(int i=0;i<car.getDetails().size();i++) {
            if(NameDetail.toUpperCase().trim().equals(car.getDetails().get(i).getName().toUpperCase())) {
                detailEntity = car.getDetails().get(i);
                break;
            }
        }
        return detailEntity;
    }

    public DetailEntity bustDetailInList(String NameDetail)
    {
        DetailEntity detailEntity = null;
        for (DetailEntity detail : details) {
            if (NameDetail.toUpperCase().trim().equals(detail.getName().toUpperCase())) {
                detailEntity = detail;
                break;
            }
        }
        return detailEntity;
    }

    public static Details getInstance(){
        if (getInstance == null){
            getInstance = new Details();
            return getInstance;
        }else
            return getInstance;
    }
}
