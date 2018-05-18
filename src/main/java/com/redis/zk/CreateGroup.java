package com.redis.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Movie on 2017/12/26.
 */
public class CreateGroup implements Watcher{
    private static final int SESSION_TIMEOUT = 5000;
    private ZooKeeper zk;
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public void connect(String hosts) throws IOException, InterruptedException {
        zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
        countDownLatch.await();
    }

    public void create(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        String createPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(createPath + "\tis created");
    }

    public void close() throws InterruptedException {
        zk.close();
    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        CreateGroup createGroup = new CreateGroup();
        createGroup.connect("127.0.0.1:2181");
        createGroup.create("zoo");
        createGroup.close();
    }
}
