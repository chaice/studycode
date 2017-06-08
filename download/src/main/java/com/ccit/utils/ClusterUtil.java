package com.ccit.utils;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import java.util.HashSet;
import java.util.Set;

public class ClusterUtil {
    private static JedisCluster cluster = null;

    static {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("123.207.214.54",7000));
        nodes.add(new HostAndPort("123.207.214.54",7001));
        nodes.add(new HostAndPort("123.207.214.54",7002));
        nodes.add(new HostAndPort("123.207.214.54",7003));
        nodes.add(new HostAndPort("123.207.214.54",7004));
        nodes.add(new HostAndPort("123.207.214.54",7005));
        cluster = new JedisCluster(nodes);
    }

    public JedisCluster getCluster() {
        return cluster;
    }
}
