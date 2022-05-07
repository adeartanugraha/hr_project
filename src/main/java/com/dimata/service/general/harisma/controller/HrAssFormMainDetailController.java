package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrAssFormMainDetail;
import com.dimata.service.general.harisma.model.body.HrAssFormMainDetailBody;
import com.dimata.service.general.harisma.service.HrAssFormMainDetailHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/ass-form-main-detail")
public class HrAssFormMainDetailController {
    @Inject
    HrAssFormMainDetailHandler hrAssFormMainDetailHandler;

    @GET
    public List<HrAssFormMainDetailBody> getFormMainDetail(@QueryParam long id) {
        return hrAssFormMainDetailHandler.getFormMainDetail(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrAssFormMainDetailBody> getAllFormMainDetail() {
        return hrAssFormMainDetailHandler.getAllFormMainDetail();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrAssFormMainDetail updateFormMainDetail(HrAssFormMainDetailBody body) {
        return hrAssFormMainDetailHandler.updateFormMainDetail(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrAssFormMainDetailBody createFormMainDetail(HrAssFormMainDetailBody body) {
        return hrAssFormMainDetailHandler.createFormMainDetail(body);
    }
}
