package com.nitish.backend.controller;

import com.nitish.backend.model.common.ApiError;
import com.nitish.backend.model.dto.webscraper.AccountInfo;
import com.nitish.backend.service.WebScraperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Web Scrapping APIs")
@RestController
@RequestMapping(value = "/api/v1/web-scraper")
public class WebScraperController {
    @Autowired
    private WebScraperService webScraperService;

    @ApiOperation(value = "Retrieve account info", notes = "Retrieve account info from web scrapper tool", response = AccountInfo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = AccountInfo.class),
            @ApiResponse(code = 400, message = "Bad Request. See error response for details", response = ApiError[].class),
            @ApiResponse(code = 500, message = "An internal server error occurred. See error response for more details", response = ApiError[].class)
    })
    @RequestMapping(value = "/account", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountInfo retrieveAccountInfo() {
        return webScraperService.retrieveAccountInfo();
    }
}
