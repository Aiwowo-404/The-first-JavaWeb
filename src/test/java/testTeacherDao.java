import com.axw.Dao.TeacherDao;
import com.axw.Pojo.Teacher;

import java.sql.SQLException;

public class testTeacherDao {
    public static void main(String[] args) {
        TeacherDao teacherDao=new TeacherDao();
        try {
            System.out.println(teacherDao.getTeacherByID("12345"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
