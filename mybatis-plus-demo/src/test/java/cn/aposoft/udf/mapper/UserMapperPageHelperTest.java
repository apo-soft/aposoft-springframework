package cn.aposoft.udf.mapper;

import cn.aposoft.springframework.App;
import cn.aposoft.udf.config.MybatisPlusConfig;
import cn.aposoft.udf.entity.User;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
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
public class UserMapperPageHelperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectUserByAgePageHelper() {
        System.out.println(("----- selectPage method test ------"));
        final int pageSize = 3;
        final int pageNum = 1;
        Page<User> page = PageHelper.startPage(1, 3);
        List userList = userMapper.selectList(Wrappers.<User>query().ge("age", 3));
        PageInfo<User> userPageInfo = new PageInfo(userList);
        Assert.assertEquals(page.getPageSize(), userPageInfo.getSize());
        Assert.assertEquals(page.getPageNum(), userPageInfo.getPageNum());

        System.out.println("records size:" + userPageInfo.getSize());
        userPageInfo.getList().forEach(System.out::println);
    }
}
