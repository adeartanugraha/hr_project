package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrArapMain;
import com.dimata.service.general.harisma.model.body.HrArapMainBody;
import com.dimata.service.general.harisma.service.HrArapMainHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/arap-main")
public class HrArapMainController {
    @Inject
    HrArapMainHandler hrArapMainHandler;

    @GET
    public List<HrArapMainBody> getArapMain(@QueryParam long id) {
        return hrArapMainHandler.getArapMain(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrArapMainBody> getAllArapMain() {
        return hrArapMainHandler.getAllHrArapMain();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrArapMain updateArapMain(HrArapMainBody body) {
        return hrArapMainHandler.updateArapMain(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrArapMainBody createArapMain(HrArapMainBody body) {
        return hrArapMainHandler.createArapMain(body);
    }
}
