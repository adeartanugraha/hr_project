package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrAssFormItem;
import com.dimata.service.general.harisma.model.body.HrAssFormItemBody;
import com.dimata.service.general.harisma.service.HrAssFormItemHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/ass-form-item")
public class HrAssFormItemController {
    @Inject
    HrAssFormItemHandler hrAssFormItemHandler;

    @GET
    public List<HrAssFormItemBody> getFormItem(@QueryParam long id) {
        return hrAssFormItemHandler.getHrFormItem(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrAssFormItemBody> getAllFormItem() {
        return hrAssFormItemHandler.getAllHrFormItem();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrAssFormItem updateFormItem(HrAssFormItemBody body) {
        return hrAssFormItemHandler.updateFormItem(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrAssFormItemBody createFormItem(HrAssFormItemBody body) {
        return hrAssFormItemHandler.createFormItem(body);
    }
}
