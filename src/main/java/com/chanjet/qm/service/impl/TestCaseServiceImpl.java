package com.chanjet.qm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chanjet.qm.beans.TestCaseBean;
import com.chanjet.qm.mapper.TestCaseMapper;
import com.chanjet.qm.service.ITestCaseService;

@Service
public class TestCaseServiceImpl implements ITestCaseService{
    @Resource
    private TestCaseMapper caseMapper;

    @Override
    public TestCaseBean addCase(TestCaseBean testCase) throws Exception {
        caseMapper.insertCase(testCase);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TestCaseBean updateCase(long caseId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TestCaseBean delCase(long caseId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TestCaseBean getCaseById(long caseId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TestCaseBean> getCaseByPId(long pid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TestCaseBean> findCaseByCaseName(String caseName) {
        // TODO Auto-generated method stub
        return null;
    }
	
	/*@Resource
	private UserMapper um;


	@Override
	public UserBean Login(String username, String password) {
		return um.login(username, password);
	}*/

}
