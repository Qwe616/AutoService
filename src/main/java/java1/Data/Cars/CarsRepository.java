package java1.Data.Cars;


import java1.Components.AutoEntity;
import java1.DBWorked;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CarsRepository {
    private ArrayList<AutoEntity> cars = new ArrayList<>();
    private DBWorked con1 = new DBWorked();

    private CarsRepository() {
        SelectCars();
    }

    private void SelectCars() {
        try {
            Statement statement = con1.getConnection().createStatement();
            String select = "SELECT * FROM AutoService.dbo.Auto";
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next()) {
                AutoEntity car = new AutoEntity();
                car.setId(resultSet.getInt(1));
                car.setName(resultSet.getString(2));
                car.setMark(resultSet.getString(3));
                car.setModel(resultSet.getString(4));
                car.setDetails(new CarDetails().SelectCarDetails(car.getId()));
                cars.add(car);
            }
            con1.getConnection().isClosed();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<AutoEntity> getAll() {
        return cars;
    }

    public void addCar(AutoEntity autoEntity) {
        try {
            String insertTempl = "INSERT INTO AutoService.dbo.Auto (Name, Mark, Model) VALUES('%s','%s','%s')";
            String insert = String.format(insertTempl,
                            autoEntity.getName(), autoEntity.getMark(), autoEntity.getModel());
            Statement statement = con1.getConnection().createStatement();
            statement.execute(insert);
            String selectAuto = "SELECT id FROM AutoService.dbo.Auto WHERE Name = '%s'";
            String select = String.format(selectAuto, autoEntity.getName());
            ResultSet resultSet = statement.executeQuery(select);
            while (resultSet.next())
            {
                autoEntity.setId(resultSet.getInt(1));
            }
            con1.getConnection().isClosed();
            cars.add(autoEntity);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(AutoEntity autoEntity)
    {
        cars.remove(autoEntity);
        try {
            String deleteTempl = "DELETE FROM AutoService.dbo.Auto WHERE Name = '%s'";
            String delete = String.format(deleteTempl, autoEntity.getName());
            Statement statement = con1.getConnection().createStatement();
            statement.executeUpdate(delete);
            con1.getConnection().isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCar (AutoEntity car, String Value, String S)
    {
        try {
            String updateCar = "UPDATE AutoService.dbo.Auto SET %s = '%s' WHERE id =%s";
            String update = String.format(updateCar,S,Value,car.getId());
            Statement statement = con1.getConnection().createStatement();
            statement.executeUpdate(update);
            con1.getConnection().isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //singleton
    private static CarsRepository getInstance;
    public static CarsRepository getInstance(){
        if (getInstance == null){
            getInstance = new CarsRepository();
            return getInstance;
        }else
            return getInstance;
    }
}
