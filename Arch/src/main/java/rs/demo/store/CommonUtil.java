package rs.demo.store;

import rs.demo.controller.MasterController;

public class CommonUtil {
public void rs_service_track(String rs_name, String by, double response) {
		int i = 0;
		for (i = 0; i < MasterController.web_services.size(); i++) {
			if (MasterController.web_services.get(i).service.equals(rs_name))
				break;
		}

		if (i != MasterController.web_services.size()) {
			int req = MasterController.web_services.get(i).request;
			MasterController.web_services.get(i).by = by;
			MasterController.web_services.get(i).request++;
			MasterController.web_services.get(i).avg_response_time = Math.round((MasterController.web_services.get(i).avg_response_time * req + response) / MasterController.web_services.get(i).request);
			
			//Math.floor(a)
			
			//MasterController.web_services.get(i).avg_response_time = Math.floor((MasterController.web_services.get(i).avg_response_time * req + response) / MasterController.web_services.get(i).request);
		}
	}
	
	
}
