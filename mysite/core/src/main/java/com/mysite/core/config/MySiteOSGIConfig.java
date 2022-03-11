package com.mysite.core.config;

import org.osgi.annotation.bundle.Attribute;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="My Site - Modular OSGI Configuration",
                        description = "Modular OSGI Config demo")
public @interface MySiteOSGIConfig {

    @AttributeDefinition(
            name = "Service ID",
            description =  "Enter service ID",
            type = AttributeType.INTEGER)
    int serviceID();

    @AttributeDefinition(
            name="Service Name",
            description = "Enter Service Name",
            type = AttributeType.STRING)
    String serviceName() default "My Site Service";

    @AttributeDefinition(
            name="Service URL",
            description = "Enter Service URL",
            type = AttributeType.STRING)
    String serviceURL() default "localhost:4502";

}
