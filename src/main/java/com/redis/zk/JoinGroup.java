package com.redis.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;

import java.io.IOException;

/**
 * Created by Movie on 2017/12/27.
 */
public class JoinGroup extends ConnectWatcher {
    public void join(String groupName, String memberName) throws KeeperException, InterruptedException {
        String path = "/" + groupName + "/" + memberName;
        String createPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(createPath + "\t is created");
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        JoinGroup joinGroup = new JoinGroup();
        joinGroup.connect("127.0.0.1:2181");
        joinGroup.join("zoo", "cow");
//        joinGroup.close();
        Thread.sleep(Long.MAX_VALUE);
    }
}
