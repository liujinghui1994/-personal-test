package com.umbrella.core.common.hbase_manage;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;


public class HBaseConfig {
    private static final String nodes = "192.168.3.104";

    public static HBaseService getHbaseService(){
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum",nodes);
        return new HBaseService(conf);
    }
}
