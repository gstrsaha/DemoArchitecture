package rs.demo.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import rs.demo.controller.MasterController;
import rs.demo.store.CommonUtil;

public class LoggingFilter {

    CommonUtil cu = new CommonUtil();

    private static final Logger logger =
            LogManager.getLogger(MasterController.class);

    long start_time = 0;
    long end_time = 0;

    public void con_entryLog(String Dev , String Service, String requestBody) {

        start_time = System.currentTimeMillis();

        logger.info("%%%%%%%%%%% " + Dev + " - Started " + Service + " %%%%%%%%%%%");
        logger.info("inputBean: " + requestBody);
    }

    public void con_exitLog(String Dev , String URI) {

        end_time = System.currentTimeMillis();

        long duration = (end_time - start_time) / 1000;

        logger.info("Turn Around Time: " + duration + "sec");

        cu.rs_service_track(URI, Dev, duration);
    }

    public void con_error(Exception e) {
        e.printStackTrace();
        logger.error("+++++++++ Wrong Input JSON Format +++++++++");
    }
}