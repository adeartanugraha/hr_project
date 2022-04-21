package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrAppraisal;
//import com.dimata.service.general.harisma.model.output.HrAppraisalOut;
import com.dimata.service.general.harisma.service.HrAppraisalHandler;

import com.dimata.service.general.harisma.model.body.HrAppraisalBody;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/appraisal")
public class HrAppraisalController {
    @Inject
    HrAppraisalHandler hrAppraisalHandler;

    @GET
    @Path("/tes")
    public String test() {
        return "TEST";
    }

    @GET
    public List<HrAppraisalBody> getAllAppraisal(@QueryParam long id){
        return hrAppraisalHandler.getHrAppraisal(id);
    }

    @PUT
    @Path("/update-appraisal")
    @Transactional
    public HrAppraisalBody updateAppraisal(HrAppraisalBody body) {
        return hrAppraisalHandler.updateAppraisal(body);
    }

    //masih error
    @POST
    @Path("/create-appraisal")
    @Transactional
    public HrAppraisalBody createAppraisal(HrAppraisalBody body) {
        return hrAppraisalHandler.createAppraisal(body);
    }
}
