package ubs.limitmanagement.controllers;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ubs.limitmanagement.exceptions.RestException;


/**
 * Created by mariiarudenko on 2/1/16.
 */
public class ExceptionHandlerController {

    private static final Logger LOG = Logger.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(RestException.class)
    public
    @ResponseBody
    String handleException(RestException e) {
        LOG.error("Error: " + e.getMessage(), e);
        return "Error: " + e.getMessage();
    }
}
