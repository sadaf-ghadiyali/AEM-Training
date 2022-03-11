package com.mysite.core.services.impl;

import com.mysite.core.config.MySiteOSGiFactoryConfig;
import com.mysite.core.services.OSGiFactoryConfig;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;

import java.util.ArrayList;
import java.util.List;

@Component(service = OSGiFactoryConfig.class, immediate = true)
@Designate(ocd = MySiteOSGiFactoryConfig.class, factory = true)
public class OSGiFactoryConfigImpl implements OSGiFactoryConfig {

    private int configID;
    private String serviceName;
    private String serviceURL;
    private List<OSGiFactoryConfig> configList;

    @Activate
    @Modified
    protected void activate(final MySiteOSGiFactoryConfig config) {
        configID = config.configID();
        serviceName=config.serviceName();
        serviceURL=config.serviceURL();
    }

    @Reference(service = OSGiFactoryConfig.class, cardinality = ReferenceCardinality.MULTIPLE,policy = ReferencePolicy.DYNAMIC)
    public void bindOSGiFactoryConfig(final OSGiFactoryConfig config){

        if(configList==null){
            configList=new ArrayList<>();
        }
        configList.add(config);
    }

    public void unbindOSGiFactoryConfig(final OSGiFactoryConfig config){
        configList.remove(config);
    }

    @Override
    public int getConfigID() {
        return configID;
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String getServiceURL() {
        return serviceURL;
    }

    @Override
    public List<OSGiFactoryConfig> getAllConfigs() {
        return configList;
    }


}
