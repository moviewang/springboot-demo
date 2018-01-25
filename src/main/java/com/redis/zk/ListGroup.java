package com.redis.zk;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Movie on 2017/12/27.
 */
public class ListGroup extends ConnectWatcher {
    public void list(String groupName) {
        String path = "/" + groupName;

        try {
            List<String> children = zk.getChildren(path, false);
            if (children == null || children.isEmpty()) {
                System.out.println("no members in group \t" + groupName);
            }
            children.forEach(s -> {
                System.out.println(s);
            });
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ListGroup listGroup = new ListGroup();
        listGroup.connect("127.0.0.1:2181");
        listGroup.list("zoo");
        listGroup.close();
    }
}
