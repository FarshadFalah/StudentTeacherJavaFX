package model.database.daos;

import model.database.DAO;
import model.database.DatabaseManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CourseDAO implements DAO {
    private static CourseDAO courseDAO=null;

    private DatabaseManager databaseManager;
    private Connection connection;

    private CourseDAO() throws IOException, SQLException {
        databaseManager=DatabaseManager.getInstance();
        connection=databaseManager.getConnection();
        PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS course(" +
                "id bigint auto_increment primary key, "+
                "_name nvarchar(50)," +
                "csid bigint," +
                "FOREIGN KEY (csid) references coursestudent(cid)"+
                ")");
        ps.executeUpdate();
    }

    public static CourseDAO getInstance() throws IOException, SQLException {
        if(courseDAO==null){
            courseDAO=new CourseDAO();
        }
        return courseDAO;
    }




    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Object getOne(Object o) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
