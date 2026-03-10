package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbook.db.ConnectionMaker;
import springbook.db.DConnectionMaker;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }

    @Bean
    private static ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
