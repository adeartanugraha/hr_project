package com.dimata.service.general.harisma.core.appconfig;

import com.dimata.service.general.harisma.core.util.CommonStatic;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path(CommonStatic.V1)
public class AppConfigController {
    public static final String BASE_URL = "/app-conf";
    public static final String ADMIN_URL = CommonStatic.ADMIN + BASE_URL;
    public static final String MAINTAINER_URL = CommonStatic.MAINTAINER + BASE_URL;

    @Inject
    protected AppConfigFactory factory;

    //----------- MAINTAINER SEC

    @POST
    @Path(MAINTAINER_URL)
    @Transactional
    public AppConfig insertConfig(AppConfig config) {
        return factory.validateThenSave(config);
    }
}
