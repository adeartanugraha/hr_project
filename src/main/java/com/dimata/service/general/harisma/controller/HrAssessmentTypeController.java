package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrAssessmentType;
import com.dimata.service.general.harisma.model.body.HrAssessmentTypeBody;
import com.dimata.service.general.harisma.service.HrAssessmentTypeHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/assessment-type")
public class HrAssessmentTypeController {
    @Inject
    HrAssessmentTypeHandler hrAssessmentTypeHandler;

    @GET
    public List<HrAssessmentTypeBody> getAssessment(@QueryParam long id) {
        return hrAssessmentTypeHandler.getAssessment(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrAssessmentTypeBody> getAllAssessment() {
        return hrAssessmentTypeHandler.getAllAssessment();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrAssessmentType updateAssessment(HrAssessmentTypeBody body) {
        return hrAssessmentTypeHandler.updateAssessment(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrAssessmentTypeBody createAssessment(HrAssessmentTypeBody body) {
        return hrAssessmentTypeHandler.createAssessment(body);
    }
}
