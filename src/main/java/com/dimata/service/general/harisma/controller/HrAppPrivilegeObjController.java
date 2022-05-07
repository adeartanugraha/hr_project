package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrAppPrivilegeObj;
import com.dimata.service.general.harisma.model.body.HrAppPrivilegeObjBody;
import com.dimata.service.general.harisma.service.HrAppPrivilegeObjHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/app-privilege-obj")
public class HrAppPrivilegeObjController {
    @Inject
    HrAppPrivilegeObjHandler hrAppPrivilegeObjHandler;

    @GET
    public List<HrAppPrivilegeObjBody> getPrivilegeObj(@QueryParam long id) {
        return hrAppPrivilegeObjHandler.getPrivilegeObj(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrAppPrivilegeObjBody> getAllPrivilegeObj() {
        return hrAppPrivilegeObjHandler.getAllPrivilegeObj();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrAppPrivilegeObj updatePrivilegeObj(HrAppPrivilegeObjBody body) {
        return hrAppPrivilegeObjHandler.updatePrivilegeObje(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrAppPrivilegeObjBody createPrivilegeObj(HrAppPrivilegeObjBody body) {
        return hrAppPrivilegeObjHandler.createPrivilegeObj(body);
    }
}
