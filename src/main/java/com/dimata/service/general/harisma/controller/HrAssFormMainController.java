package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.model.body.HrAssFormMainBody;
import com.dimata.service.general.harisma.service.HrAssFormMainHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/ass-form-main")
public class HrAssFormMainController {
    @Inject
    HrAssFormMainHandler hrAssFormMainHandler;

    @GET
    public List<HrAssFormMainBody> getFormMain(@QueryParam long id) {
        return hrAssFormMainHandler.getFormMain(id);
    }

    @PUT
    @Path("/update-form-main")
    @Transactional
    public HrAssFormMainBody updateFormMain(HrAssFormMainBody body) {
        return hrAssFormMainHandler.updateFormMain(body);
    }
}
