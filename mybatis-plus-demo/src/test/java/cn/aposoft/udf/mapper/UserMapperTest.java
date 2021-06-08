package cn.aposoft.udf.mapper;

import cn.aposoft.springframework.App;
import cn.aposoft.udf.config.MybatisPlusConfig;
import cn.aposoft.udf.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(classes = {App.class, MybatisPlusConfig.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() {
        System.out.println(("----- selectPage method test ------"));
        Page page = new Page<User>(1, 3);
        page.addOrder(OrderItem.desc("id"));
        QueryWrapper<User> queryWrapper = Wrappers.<User>query().ge(true, "id", 0);
        IPage<User> userPage = userMapper.selectPage(page, queryWrapper);
        Assert.assertEquals(page.getSize(), userPage.getSize());
        Assert.assertEquals(page.getCurrent(), userPage.getCurrent());
        List<User> records = userPage.getRecords();
        System.out.println("records size:" + records.size());
        records.forEach(System.out::println);
    }

    @Test
    public void testSelectPageQueryWrapper() {
        System.out.println(("----- selectPage method test ------"));
        Page page = new Page<User>(2, 3);

        QueryWrapper<User> queryWrapper = Wrappers.<User>query().ge(true, "id", 0).orderByAsc("id");
        IPage<User> userPage = userMapper.selectPage(page, queryWrapper);
        Assert.assertEquals(page.getSize(), userPage.getSize());
        Assert.assertEquals(page.getCurrent(), userPage.getCurrent());
        List<User> records = userPage.getRecords();
        System.out.println("records size:" + records.size());
        records.forEach(System.out::println);
    }

    @Test
    public void testSelectUserBySexPage() {
        System.out.println(("----- selectPage method test ------"));
        Page page = new Page<User>(1, 3).addOrder(OrderItem.asc("age"));
        IPage<User> userPage = userMapper.selectBySexPage(page, "男");
        Assert.assertEquals(page.getSize(), userPage.getSize());
        Assert.assertEquals(page.getCurrent(), userPage.getCurrent());
        List<User> records = userPage.getRecords();
        System.out.println("records size:" + records.size());
        records.forEach(System.out::println);
    }

    @Test
    public void testSelectUserByAgePage() {
        System.out.println(("----- selectPage method test ------"));
        Page page = new Page<User>(1, 3).addOrder(OrderItem.desc("age"));
        IPage<User> userPage = userMapper.selectByAgePage(page, 1);
        Assert.assertEquals(page.getSize(), userPage.getSize());
        Assert.assertEquals(page.getCurrent(), userPage.getCurrent());
        List<User> records = userPage.getRecords();

        System.out.println("records size:" + records.size());
        records.forEach(System.out::println);
    }


}
