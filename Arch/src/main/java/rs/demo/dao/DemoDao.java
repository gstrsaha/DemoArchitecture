package rs.demo.dao;

import org.springframework.stereotype.Repository;

import rs.demo.model.DemoReq;


public interface DemoDao {
public String getDataDao( DemoReq demoReq) throws Exception;
}
