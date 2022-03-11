package com.mysite.core.models.Impl;

import com.mysite.core.models.Author;
import com.mysite.core.models.OSGiConfigDemo;
import com.mysite.core.models.OSGiConfigModule;
import com.mysite.core.services.OSGiConfig;
import com.mysite.core.services.OSGiFactoryConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = OSGiConfigDemo.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class OSGiConfigDemoImpl implements OSGiConfigDemo {

    @OSGiService
    OSGiConfig osGiConfig;

    @OSGiService
    OSGiConfigModule osGiConfigModule;

    @OSGiService
    OSGiFactoryConfig osGiFactoryConfig;

    @Override
    public String getServiceName() {
        return osGiConfig.getServiceName();
    }

    @Override
    public int getServiceCount() {
        return osGiConfig.getServiceCount();
    }

    @Override
    public boolean isLiveData() {
        return osGiConfig.isLiveData();
    }

    @Override
    public String[] getCountries() {
        return osGiConfig.getCountries();
    }

    @Override
    public String getRunModes() {
        return "osGiConfig";
    }

    @Override
    public int getServiceCountModule() {
        return osGiConfigModule.getServiceId();
    }

    @Override
    public String getServiceNameModule() {
        return osGiConfigModule.getServiceName();
    }

    @Override
    public List<OSGiFactoryConfig> getAllOSGiConfig() {
        return osGiFactoryConfig.getAllConfigs();
    }
}
