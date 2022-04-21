package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.model.body.HrAssFormSectionBody;
import com.dimata.service.general.harisma.service.HrAssFormSectionHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/ass-form-section")
public class HrAssFormSectionController {
    @Inject
    HrAssFormSectionHandler hrAssFormSectionHandler;

    @GET
    public List<HrAssFormSectionBody> getFormSection(@QueryParam long id) {
        return hrAssFormSectionHandler.getFormSection(id);
    }

    @PUT
    @Path("/update-form-section")
    @Transactional
    public HrAssFormSectionBody updateFormSection (HrAssFormSectionBody body) {
        return hrAssFormSectionHandler.updateFormSection(body);
    }
}
