package com.personal.test01.redislock;

public interface DistributedLock {

    public boolean lock(String key);

    public boolean release(String key);
}
