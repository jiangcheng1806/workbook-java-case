package com.jiangcz.application.http.jedis;

import redis.clients.jedis.Jedis;

public class JedisSample {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("49.234.227.194",6379);
        jedis.set("hello","world");
        String value = jedis.get("hello");
        System.out.println(value);
        jedis.del("hello");
        System.out.println(jedis.get("hello"));
    }
}
