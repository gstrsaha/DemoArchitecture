package rs.demo.service;

import org.springframework.stereotype.Service;

import rs.demo.model.DemoReq;


public interface DemoService {
    public String getData(DemoReq demoReq) throws Exception;

}
