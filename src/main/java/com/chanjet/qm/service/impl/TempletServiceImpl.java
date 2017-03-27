package com.chanjet.qm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chanjet.qm.beans.TempletBean;
import com.chanjet.qm.mapper.TempletMapper;
import com.chanjet.qm.service.ITempletService;

@Service
public class TempletServiceImpl implements ITempletService {

    @Resource
    private TempletMapper templMapper;

    @Override
    public TempletBean addModule(TempletBean module) throws Exception {
        return templMapper.insertModule(module);
    }

    @Override
    public TempletBean updateModule(TempletBean module) throws Exception {

        return templMapper.updateModule(module, module.getId());
    }

    @Override
    public TempletBean delModule(long moduleId) throws Exception {
        templMapper.deleteModule(moduleId);
        return null;
    }

    @Override
    public TempletBean getModuleById(long moduleId) throws Exception {
       
        return  templMapper.getModuleById(moduleId);
    }

    @Override
    public List<TempletBean> getAllModule() {

        return templMapper.getAllModules();
    }

    public int getAllModuleCount() {
        return templMapper.getAllModuleCount();
    }

    public List<TempletBean> getModuleByPage(int skip, int take) {
        Map map = new HashMap();
        map.put("skip", skip);
        map.put("take", take);
        return templMapper.getModuleByPage(map);
        // return null;
    }

}
