package cn.aposoft.udf.mapper;

import cn.aposoft.udf.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Jann Liu
 * @since 2021-03-14
 */
public interface UserMapper extends BaseMapper<User> {
    IPage<User> selectBySexPage(@Param("pg") Page<User> page, @Param("sex") String sex);

    IPage<User> selectByAgePage(@Param("pg") Page<User> page, @Param("age") Integer age);
}
