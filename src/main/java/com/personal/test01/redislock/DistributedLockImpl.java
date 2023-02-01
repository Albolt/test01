package com.personal.test01.redislock;

import com.personal.test01.everyOther.Md5;

import java.security.NoSuchAlgorithmException;

public class DistributedLockImpl implements DistributedLock {

    private RedisClient redisClient;

    @Override
    public synchronized boolean lock(String key) {
        String value = Thread.currentThread().getName();
        Long timeout = System.currentTimeMillis();

        String rValue = redisClient.get(key);
        if (redisClient.exists(key)) {
            Boolean result = redisClient.put(key, value, timeout);
            return result;
        } else {
            if (value.equals(rValue)) {
                redisClient.expire(key, timeout.intValue());
            }
        }
        return false;
    }

    @Override
    public synchronized boolean release(String key) {

        String value = Thread.currentThread().getName();

        if (!redisClient.exists(key)) {
            return false;
        } else {
            String rValue = redisClient.get(key);
            if (value.equals(rValue)) {
                redisClient.delete(key);
                return true;
            }
        }

        return false;
    }
}
