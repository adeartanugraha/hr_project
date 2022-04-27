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
    public List<HrAppraisalBody> getAppraisal(@QueryParam long id){
        return hrAppraisalHandler.getHrAppraisal(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrAppraisalBody> getAllAppraisal(){
        return hrAppraisalHandler.getAllHrAppraisal();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrAppraisal updateAppraisal(HrAppraisalBody body) {
        return hrAppraisalHandler.updateAppraisal(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrAppraisalBody createAppraisal(HrAppraisalBody body) {
        return hrAppraisalHandler.createAppraisal(body);
    }
}
