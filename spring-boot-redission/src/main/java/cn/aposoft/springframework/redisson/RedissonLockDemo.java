package cn.aposoft.springframework.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * RLock 是一个可重入Lock，底层通过redis-hash结构实现。
 * 加锁的过程，底层执行LUA脚本，详见：
 */
public class RedissonLockDemo {
    public static void main(String[] args) {
        RedissonClient redisson = Redisson.create();

        RLock lock = redisson.getLock("TEST-LOCK");
        try {
            lock.lock(1000*20, TimeUnit.MILLISECONDS);
            System.out.println("redis-locked.");
        } finally {
            lock.unlock();
            System.out.println("redis-unlocked.");
        }
        System.out.println("Hello World!");
        redisson.shutdown();
    }
}
