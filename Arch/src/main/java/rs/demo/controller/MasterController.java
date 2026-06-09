package rs.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.demo.model.DemoReq;

@RestController
public class MasterController implements MasterURIConstant {
    //Demo Purpose Get Mapping
    @RequestMapping(value = MasterURIConstant.GET_WELCOME, method = RequestMethod.GET, produces = "application/json", headers = {
			"Accept=application/json" })
    public String helloPrint()
     {
        return "hello";
     }
     //Demo Purpose Post Mapping
     @RequestMapping(value = MasterURIConstant.POST_WELCOME, method = RequestMethod.POST,produces = "application/json",headers = {
        "Accept=application/json" })
     public String namePrint(@RequestBody DemoReq demReq)
     {
        return "hello welcome  "+demReq.getName();
     }

}
