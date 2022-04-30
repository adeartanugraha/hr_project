package com.dimata.service.general.harisma.controller;

import com.dimata.service.general.harisma.entity.HrArapPayment;
import com.dimata.service.general.harisma.model.body.HrArapPaymentBody;
import com.dimata.service.general.harisma.service.HrArapPaymentHandler;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("api/v1/maintainer/arap-payment")
public class HrArapPaymentController {
    @Inject
    HrArapPaymentHandler hrArapPaymentHandler;

    @GET
    public List<HrArapPaymentBody> getPayment(@QueryParam long id) {
        return hrArapPaymentHandler.getHrArapPayment(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<HrArapPaymentBody> getAllPayment() {
        return hrArapPaymentHandler.getAllHrArapPayment();
    }

    @PUT
    @Path("/update")
    @Transactional
    public HrArapPayment updatePayment(HrArapPaymentBody body) {
        return hrArapPaymentHandler.updateArapPayment(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public HrArapPaymentBody createPayment(HrArapPaymentBody body) {
        return hrArapPaymentHandler.createArapPayment(body);
    }
}
