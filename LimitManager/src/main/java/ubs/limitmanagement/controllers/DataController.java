package ubs.limitmanagement.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ubs.limitmanagement.exceptions.RestException;
import ubs.limitmanagement.util.Ajax;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mariiarudenko on 2/1/16.
 */
@Controller
public class DataController extends ExceptionHandlerController {

    private static final Logger LOG = Logger.getLogger(DataController.class);

    //@Autowired
    //@Qualifier("dataService")
    //private DatabaseService databaseService;

    @RequestMapping(value = "/postRequest", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, Object> persist(@RequestParam("data") String data) throws RestException {
        try {
            if (data == null || data.equals("")) {
                return Ajax.emptyResponse();
            }

            return Ajax.emptyResponse();
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

    @RequestMapping(value = "/getRequest", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> getRandomData() throws RestException {
        try {
            Set<String> result = new HashSet<>();
            return Ajax.successResponse(result);
        } catch (Exception e) {
            throw new RestException(e);
        }
    }

}
