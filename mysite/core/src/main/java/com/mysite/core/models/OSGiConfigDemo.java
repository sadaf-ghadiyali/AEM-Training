package com.mysite.core.models;

import com.mysite.core.services.OSGiFactoryConfig;

import java.util.List;

public interface OSGiConfigDemo {

    public String getServiceName();
    public int getServiceCount();
    public boolean isLiveData();
    public String[] getCountries() ;
    public String getRunModes();

    public int getServiceCountModule();
    public String getServiceNameModule();

    public List<OSGiFactoryConfig> getAllOSGiConfig();


}
