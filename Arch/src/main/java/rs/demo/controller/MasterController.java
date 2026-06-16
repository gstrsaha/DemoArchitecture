package rs.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.demo.log.LoggingFilter;
import rs.demo.model.DemoReq;
import rs.demo.model.Rs;
import rs.demo.store.CommonUtil;

@RestController
public class MasterController implements MasterURIConstant {

   public static List<String> service_name = Arrays.asList(
         "/welcome",
         "/");

   public static List<Rs> web_services = new ArrayList<Rs>();

   public MasterController() {
      for (String rs_name : service_name) {
         Rs ws_obj = new Rs();
         ws_obj.service = rs_name;
         web_services.add(ws_obj);
      }
   }

   LoggingFilter lf = new LoggingFilter();

   // Demo Purpose Get Mapping
   @RequestMapping(value = MasterURIConstant.GET_WELCOME, method = RequestMethod.GET, produces = "application/json", headers = {
         "Accept=application/json" })
   public String helloPrint() {
      lf.con_entryLog("RS", "demo", "");
      String x = "hello";
      lf.con_exitLog("RS", "MasterURIConstant.GET_WELCOME");
      return x;
   }

   // Demo Purpose Post Mapping
   @RequestMapping(value = MasterURIConstant.POST_WELCOME, method = RequestMethod.POST, produces = "application/json", headers = {
         "Accept=application/json" })
   public String namePrint(@RequestBody DemoReq demReq) {

      lf.con_entryLog("RS", "POST_WELCOME", demReq.getName());

      String response = "hello welcome " + demReq.getName();

      lf.con_exitLog("RS", MasterURIConstant.POST_WELCOME);

      return response;
   }

   // Demo Purpose Post Mapping with DB
   @RequestMapping(value = MasterURIConstant.POST__DB_DEMO, method = RequestMethod.POST, produces = "application/json", headers = {
         "Accept=application/json" })
   public String dbValFetch(@RequestBody DemoReq demReq) {
      lf.con_entryLog("RS", "POST__DB_DEMO", demReq.getName());

      String response = "hello welcome " + demReq.getName();

      lf.con_exitLog("RS", MasterURIConstant.POST__DB_DEMO);

      return response;
   }
}
