package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrAppPrivilege;
import com.dimata.service.general.harisma.model.body.HrAppPrivilegeBody;
import com.dimata.service.general.harisma.service.HrAppPrivilegeHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/app-privilege")
public class HrAppPrivilegeController {
    @Inject
    HrAppPrivilegeHandler hrAppPrivilegeHandler;

    @GET
    public List<HrAppPrivilegeBody> getPrivilige(@QueryParam long id) {
        return hrAppPrivilegeHandler.getHrAppPrivilege(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrAppPrivilegeBody> getAllPrivilege() {
        return hrAppPrivilegeHandler.getAllHrAppPrivilege();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrAppPrivilege updatePrivilege(HrAppPrivilegeBody body) {
        return hrAppPrivilegeHandler.updateAppPrivilege(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrAppPrivilegeBody createPrivilege(HrAppPrivilegeBody body) {
        return hrAppPrivilegeHandler.createAppPrivilege(body);
    }
}
