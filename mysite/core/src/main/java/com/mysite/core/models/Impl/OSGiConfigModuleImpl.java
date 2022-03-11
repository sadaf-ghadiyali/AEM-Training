package com.mysite.core.models.Impl;

import com.mysite.core.config.MySiteOSGIConfig;
import com.mysite.core.models.OSGiConfigModule;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = OSGiConfigModule.class,immediate = true)
@Designate(ocd = MySiteOSGIConfig.class)
public class OSGiConfigModuleImpl implements OSGiConfigModule{

    private int serviceId;
    private String serviceName;
    private String serviceURL;

    @Activate
    public void activate(MySiteOSGIConfig mySiteOSGIConfig){
        serviceId=mySiteOSGIConfig.serviceID();
        serviceName=mySiteOSGIConfig.serviceName();
        serviceURL=mySiteOSGIConfig.serviceURL();
    }


    @Override
    public int getServiceId() {
        return serviceId;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String getServiceURL() {
        return serviceURL;
    }
}
