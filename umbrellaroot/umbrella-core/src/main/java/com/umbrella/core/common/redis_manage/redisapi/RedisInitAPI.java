package com.umbrella.core.common.redis_manage.redisapi;

import com.umbrella.core.metadata_manage.InstanceVO;
import com.umbrella.core.metadata_manage.dao.IMetadataManageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Pipeline;

import javax.annotation.PostConstruct;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @program: com.umbrella.core.common.redis_manage.redisapi
 * @description:
 * @author: liujinghui
 * @create: 2019-01-12 17:14
 **/
@Component
public class RedisInitAPI extends RedisBaseAPI{
    @Autowired
   private IMetadataManageDao iMetadataManageDao;
    @Autowired
   private RedisStringAPI redisStringAPI;

  /*  SELECT CONCAT(
   "*8\n",
           '$',LENGTH(redis_cmd),'\n',redis_cmd,'\n',
            '$',LENGTH(redis_key),'\n',redis_key,'\n',
            '$',LENGTH(hkey1),'\n',hkey1,'\n','$',LENGTH(hval1),'\n',hval1,'\n',
            '$',LENGTH(hkey2),'\n',hkey2,'\n','$',LENGTH(hval2),'\n',hval2,'\n',
            '$',LENGTH(hkey3),'\n',hkey3,'\n','$',LENGTH(hval3),'\n',hval3
)FROM(
            SELECT 'HMSET' AS redis_cmd,
            concat_ws(':','person', id) AS redis_key,
   'id' AS hkey1, id AS hval1,
   'name' AS hkey2, name AS hval2,
   'age' AS hkey3, age AS hval3
    From person
)AS t*/

    public void initMetadata(){
        redisStringAPI.mSet("aaa","bbb","ccc","bbb");

        long start_query=System.currentTimeMillis();
//        List<InstanceVO> metadataList = iMetadataManageDao.queryMetadata();
//        List<String> metadataIdList = iMetadataManageDao.queryAllMetadataId();
        long end_query=System.currentTimeMillis();

        Pipeline pipe = jedisPool.getResource().pipelined();

        long start_pipe=System.currentTimeMillis();
        int i=0;
//        for (String id : metadataIdList) {
//            i++;
//            pipe.set(id,id);
//            if(i==1000){
//                pipe.sync();
//                i=0;
//            }
//        }
/*
        for (InstanceVO instanceVO : metadataList) {
            i++;
            pipe.set(instanceVO.getId(),instanceVO.toString());
            if(i==1000){
                pipe.sync();
                i=0;
            }
        }
*/
        pipe.sync();
        long end_pipe=System.currentTimeMillis();
        System.out.println("init方法结束 耗时："+(end_pipe-start_pipe));
    }

}
