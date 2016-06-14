package java1.Data.Cars;

import java1.Components.DetailEntity;
import java1.DBWorked;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class CarDetails {
    private ArrayList<DetailEntity> details = new ArrayList<>();
    private DBWorked con1 = new DBWorked();

    ArrayList<DetailEntity> SelectCarDetails(int AutoId)
    {
        String select = "SELECT DISTINCT Details_id,d.Name FROM AutoService.dbo.AutoDetailsProperties adp\n" +
                "JOIN AutoService.dbo.Details d\n" +
                "ON d.id = adp.Details_id\n" +
                "WHERE Auto_id = " + AutoId;
        try {
            Statement statement = con1.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next())
            {
                DetailEntity detail = new DetailEntity();
                detail.setId(resultSet.getInt(1));
                detail.setName(resultSet.getString(2));
                detail.setPropertyEntity(new CarPropertiesDetails().SelectCarDetailsProperties(detail.getId(),AutoId));
                details.add(detail);
            }
            con1.getConnection().isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

}