package rs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.demo.dao.DemoDao;
import rs.demo.model.DemoReq;
@Service
public class DemoServiceImpl implements DemoService{
    @Autowired
    private DemoDao demoDao;
    @Override
    public String getData(DemoReq demoReq) throws Exception {
        return demoDao.getDataDao(demoReq);
    }


}
