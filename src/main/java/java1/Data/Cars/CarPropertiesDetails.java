package java1.Data.Cars;

import java1.Components.PropertyEntity;
import java1.DBWorked;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class CarPropertiesDetails {
    private ArrayList<PropertyEntity> properties = new ArrayList<>();
    private DBWorked con = new DBWorked();

    ArrayList<PropertyEntity> SelectCarDetailsProperties(int DetailId, int AutoId)
    {
        String selectProperty = "SELECT Properties_id,p.Name, adp.[Values] FROM  AutoService.dbo.AutoDetailsProperties adp\n" +
                "JOIN AutoService.dbo.Properties p\n" +
                "ON adp.Properties_id = p.id\n" +
                "WHERE Details_id = " + DetailId + "AND Auto_id = " + AutoId;
        try {
            Statement statement =  con.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(selectProperty);

            while (resultSet.next())
            {
                PropertyEntity propertyEntity = new PropertyEntity();
                propertyEntity.setId(resultSet.getInt(1));
                propertyEntity.setName(resultSet.getString(2));
                propertyEntity.setValue(resultSet.getString(3));
                properties.add(propertyEntity);
            }
            con.getConnection().isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
