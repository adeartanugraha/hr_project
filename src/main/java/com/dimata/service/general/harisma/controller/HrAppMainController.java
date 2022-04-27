package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrAppMain;
import com.dimata.service.general.harisma.model.body.HrAppMainBody;
import com.dimata.service.general.harisma.service.HrAppMainHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/app-main")
public class HrAppMainController {
    @Inject
    HrAppMainHandler hrAppMainHandler;

    @GET
    public List<HrAppMainBody> getHrAppMain(@QueryParam long id) {
        return hrAppMainHandler.getHrAppMain(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrAppMainBody> getAllHrAppMain(){
        return hrAppMainHandler.getAllHrAppMain();
    }


    @PUT
    @Path("/update")
    @Transactional
    public HrAppMain updateAppMain(HrAppMainBody body) {
        return hrAppMainHandler.updateAppMain(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrAppMainBody createAppMain(HrAppMainBody body) {
        return hrAppMainHandler.createAppMain(body);
    }

}
