package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrArapCreditor;
import com.dimata.service.general.harisma.model.body.HrArapCreditorBody;
import com.dimata.service.general.harisma.service.HrArapCreditorHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintariner/arap-priviliege")
public class HrArapCreditorController {
    @Inject
    HrArapCreditorHandler hrArapCreditorHandler;

    @GET
    public List<HrArapCreditorBody> getCreditor(@QueryParam long id) {
        return hrArapCreditorHandler.getCreditor(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrArapCreditorBody> getAllCreditor() {
        return hrArapCreditorHandler.getAllCreditor();
    }

    @PUT
    @Path("update")
    @Transactional
    public HrArapCreditor updateCreditor(HrArapCreditorBody body) {
        return hrArapCreditorHandler.updateCreditor(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrArapCreditorBody createCreditor(HrArapCreditorBody body) {
        return hrArapCreditorHandler.createCreditor(body);
    }
}
