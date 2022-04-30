package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrArapItem;
import com.dimata.service.general.harisma.model.body.HrArapItemBody;
import com.dimata.service.general.harisma.service.HrArapItemHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/arap-item")
public class HrArapItemController {
    @Inject
    HrArapItemHandler hrArapItemHandler;

    @GET
    public List<HrArapItemBody> getItem(@QueryParam long id) {
        return hrArapItemHandler.getHrArapItem(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrArapItemBody> getAllItem() {
        return hrArapItemHandler.getAllArapIten();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrArapItem updateItem(HrArapItemBody body) {
        return hrArapItemHandler.updateArapItem(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrArapItemBody createItem(HrArapItemBody body) {
        return hrArapItemHandler.createArapItem(body);
    }
}
