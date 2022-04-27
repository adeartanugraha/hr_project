package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrAppGroup;
import com.dimata.service.general.harisma.model.body.HrAppGroupBody;
import com.dimata.service.general.harisma.service.HrAppGroupHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/app-group")
public class HrAppGroupController {
    @Inject
    HrAppGroupHandler hrAppGroupHandler;

    @GET
    public List<HrAppGroupBody> getGroup(@QueryParam long id) {
        return hrAppGroupHandler.getHrAppGroup(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrAppGroupBody> getAllGroup(){
        return hrAppGroupHandler.getAllHrAppGroup();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrAppGroup updateGroup(HrAppGroupBody body) {
        return hrAppGroupHandler.updateAppGroup(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrAppGroupBody createGroup(HrAppGroupBody body) {
        return hrAppGroupHandler.createAppGroup(body);
    }
}
