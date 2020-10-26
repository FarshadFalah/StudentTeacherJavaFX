package model.database.daos;

import model.database.DAO;
import model.database.DatabaseManager;
import model.person.Teacher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TeacherDAO implements DAO {
    private static TeacherDAO teacherDAO=null;

    private DatabaseManager databaseManager;
    private Connection connection;

    private TeacherDAO() throws IOException, SQLException {
        databaseManager=DatabaseManager.getInstance();
        connection=databaseManager.getConnection();
        PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS teacher(" +
                "id bigint auto_increment primary key, "+
                "_name nvarchar(50)," +
                "cid bigint," +
                "FOREIGN KEY (cid) references course(id)"+
                ")");
        ps.executeUpdate();
    }

    public static TeacherDAO getInstance() throws IOException, SQLException {
        if(teacherDAO==null){
            teacherDAO=new TeacherDAO();
        }
        return teacherDAO;
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
