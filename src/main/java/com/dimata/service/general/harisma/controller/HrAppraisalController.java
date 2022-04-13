package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.service.HrAppraisalHandler;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("api/v1/maintainer/appraisal")
public class HrAppraisalController {
    @Inject
    HrAppraisalHandler hrAppraisalHandler;

    @GET
    public String test() {
        return "TEST";
    }
}
