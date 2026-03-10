import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.db.ConnectionMaker;
import springbook.db.DConnectionMaker;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        UserDao dao = new UserDao(connectionMaker);

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        Connection c = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
        c.createStatement().execute(
                "create table users (id varchar(10) primary key, name varchar(20) not null, password varchar(10) not null)"
        );
        dao.add(user);

        System.out.println(user.getId() + "등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회 성공");
    }
}
