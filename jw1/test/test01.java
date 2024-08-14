import com.javaweb.dao.UsersDao;
import com.javaweb.db.JDBCUtils;
import com.javaweb.handledb.HandleClass;
import com.javaweb.projectdb01.Users;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class test01 {
    @Test
    public void m1() {
        System.out.println("1111111");
        Connection conn = JDBCUtils.getConnection();
        System.out.println("conn = " + conn);
        String sql = "insert into users(username,password) values(?,?)";
        String sql2 = "select * from users";
        QueryRunner queryRunner = new QueryRunner();
        try {
            //queryRunner.update(conn, sql,"admin123456","abc789456");
            Users query = queryRunner.query(conn, sql2, new BeanHandler<>(Users.class));
            System.out.println("query = " + query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
