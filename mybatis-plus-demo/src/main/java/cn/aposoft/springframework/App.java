package cn.aposoft.springframework;

import cn.aposoft.udf.entity.User;
import cn.aposoft.udf.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = "cn.aposoft.udf.config")
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//        jdbcTemplateExecute(context);
        mybatisPlusExecute(context);
        context.close();
    }

    private static void jdbcTemplateExecute(ApplicationContext context){
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT * FROM user limit 1");
        System.out.println("\n");
        System.out.println(result);
        System.out.println("\n");
    }

    private static void mybatisPlusExecute(ApplicationContext context){
        UserMapper userMapper = context.getBean(UserMapper.class);
        List<User> userList = userMapper.selectList(null);
        System.out.println("use mybatis plus:\n");
        System.out.println(userList);
        System.out.println("\nend use mybatis plus.");
    }
}
