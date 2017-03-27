package com.chanjet.qm.service;

import java.util.List;

import com.chanjet.qm.beans.TempletBean;

public interface ITempletService {

    public TempletBean addModule(TempletBean module) throws Exception;

    public TempletBean updateModule(TempletBean module) throws Exception;

    public TempletBean delModule(long moduleId) throws Exception;

    public TempletBean getModuleById(long moduleId) throws Exception;
    public List<TempletBean> getAllModule();
    public int getAllModuleCount();
    public List<TempletBean> getModuleByPage(int skip,int take);
}
