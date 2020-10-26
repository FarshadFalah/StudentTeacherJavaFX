package model.database.daos;

import model.database.DAO;
import model.database.DatabaseManager;
import model.person.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO implements DAO {
    private static StudentDAO studentDAO=null;

    private DatabaseManager databaseManager;
    private Connection connection;

    private StudentDAO() throws IOException, SQLException {
        databaseManager=DatabaseManager.getInstance();
        connection=databaseManager.getConnection();
        PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS student(" +
                "id bigint auto_increment primary key, "+
                "_name nvarchar(50)," +
                "csid bigint," +
                "FOREIGN KEY (csid) references coursestudent(sid)"+
                ")");
        ps.executeUpdate();
    }

    public static StudentDAO getInstance() throws IOException, SQLException {
       if(studentDAO==null){
           studentDAO=new StudentDAO();
       }
       return studentDAO;
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
