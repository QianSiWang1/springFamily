package com.qy.bootzookeeper.client;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

public class ZkClientDemo {
    private static final  String  CONNECT_STR="localhost:2181";
    //private final static String CLUSTER_CONNECT_STR = "192.168.65.163:2181,192.168.65.184:2181,192.168.65.186:2181";

    public static void main(String[] args) throws Exception {
        //获取zookeeper对象
        ZooKeeper zooKeeper = ZooKeeperFacotry.create(CONNECT_STR);

        //CONNECTED
        System.out.println(zooKeeper.getState());

        Stat stat = zooKeeper.exists("/user", false);
        if (null == stat) {
            //创建持久节点
            zooKeeper.create("/user", "qy".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        //永久监听  addWatch -m mode  /user
        zooKeeper.addWatch("/user", new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println(event);
                //TODO
            }
        }, AddWatchMode.PERSISTENT);


        stat = new Stat();
        byte[] data = zooKeeper.getData("/user", false, stat);
        System.out.println(" data: " + new String(data));
        // -1: 无条件更新
        //zooKeeper.setData("/user", "third".getBytes(), -1);
        // 带版本条件更新
        int version = stat.getVersion();

        zooKeeper.setData("/user", "qy".getBytes(), version);


        Thread.sleep(Integer.MAX_VALUE);

    }
}
