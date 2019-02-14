package com.umbrella.core.metadata_manage.dao;

import com.umbrella.core.metadata_manage.InstanceVO;
import com.umbrella.core.user_manage.model.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMetadataManageDao {

    public List<InstanceVO> queryMetadata();

    public List<String> queryAllMetadataId();
}
