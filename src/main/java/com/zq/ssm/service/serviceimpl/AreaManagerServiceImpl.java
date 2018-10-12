package com.zq.ssm.service.serviceimpl;

import com.zq.ssm.dao.AreabikeMapper;
import com.zq.ssm.dao.AreamanagerMapper;
import com.zq.ssm.model.Areabike;
import com.zq.ssm.model.Areamanager;
import com.zq.ssm.service.AreaManagerService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AreaManagerServiceImpl implements AreaManagerService {

   // private final static Logger log = LoggerFactory.getLogger(AreaManagerServiceImpl.class);

    @Resource
    private  AreamanagerMapper areamanagerMapper;

    @Resource
    private AreabikeMapper areabikeMapper;

    @Override
    public List<Areamanager> SelectAllAreaManager() {

        return areamanagerMapper.SelectAllAreaManager();
    }

    @Override
    public int addAreaManager(Areamanager areamanager) {
      int countAreaManager =  areamanagerMapper.insert(areamanager);
        //log.info("--------------countAreaManager--------------{}"+countAreaManager);
        return countAreaManager;
    }

/*获取区域名称*/
    @Override
    public List<Areabike> SelectforAreaForBike() {

        return  areabikeMapper.SelectforAreaForBike();
    }

    @Override
    public int deleteAreaManager(int id) {
        return areamanagerMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Areamanager selectAreaManagerById(int id) {
        return areamanagerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void beachDeleteAreaManager(List<Integer> ids) {
         areamanagerMapper.batchDeleteAreamanager(ids);
    }

    @Override
    public Areamanager findAreaManagerById(int id) {
        // TODO Auto-generated method stub
        return areamanagerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int  updateAreaManager(Areamanager areamanager) {
        int updateByPrimaryKey = areamanagerMapper.updateByPrimaryKey(areamanager);
        return updateByPrimaryKey;

    }

    @Override
    public List<Areamanager> SelectAreaManagerForAreaNameOrAreaManagerName(Areamanager areamanager) {

        return areamanagerMapper.SelectAreaManagerForAreaNameOrAreaManagerName(areamanager);
    }
}
