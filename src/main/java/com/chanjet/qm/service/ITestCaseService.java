package com.chanjet.qm.service;

import java.util.List;

import com.chanjet.qm.beans.TestCaseBean;

public interface ITestCaseService {

    public TestCaseBean addCase(TestCaseBean testCase) throws Exception;

    public TestCaseBean updateCase(long caseId) throws Exception;

    public TestCaseBean delCase(long caseId) throws Exception;

    public TestCaseBean getCaseById(long caseId) throws Exception;

    public List<TestCaseBean> getCaseByPId(long pid) throws Exception;

    public List<TestCaseBean> findCaseByCaseName(String caseName) throws Exception;

}
