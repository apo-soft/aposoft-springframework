package cn.aposoft.udf.service.impl;

import cn.aposoft.udf.entity.User;
import cn.aposoft.udf.mapper.UserMapper;
import cn.aposoft.udf.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jann Liu
 * @since 2021-03-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
