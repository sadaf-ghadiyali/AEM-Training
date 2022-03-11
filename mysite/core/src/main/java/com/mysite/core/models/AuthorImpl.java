package com.mysite.core.models;

import com.day.cq.wcm.api.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = Author.class,
        resourceType = AuthorImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name="jackson",extensions = "json",selector="site",
            options = {
                    @ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value="true"),
                @ExporterOption(name= "SerializationFeature.WRAP_ROOT_VALUE",value="true")

            }
)

@JsonRootName("author-details")
public class AuthorImpl implements Author{

    public static final Logger LOG= LoggerFactory.getLogger(com.mysite.core.models.Impl.AuthorImpl.class);

    static final String RESOURCE_TYPE="mysite/components/author";

    @SlingObject
    ResourceResolver resourceResolver;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;

    @ScriptVariable
    Page currentPage;

    @RequestAttribute(name = "myAttribute")
    String myAttribute;

    @ResourcePath(path="/content/mysite/us/en/home")
    @Via("resource")
    Resource resource;

    @ValueMapValue
    @Default(values="MY")
    String fname;

    @Inject
    @Via("resource")
    @Default(values="SITE")
    String lname;

    @JsonProperty(value = "sample")
    public String propertyMethod(){
        return "JSON Property Example";
    }

    @Override
    public String getFirstName(){
        return fname;
    }
    @Override
    public String getLastName(){
        return lname;
    }


    @Override
    @JsonProperty(value="Page Title")
    public String getCurrentPage() {
        return currentPage.getTitle();
    }

    @Override
    public String getHomePageName() {
        return resource.getName();
    }

    @JsonIgnore
    public String getMyAttribute() {
        return myAttribute;
    }

    @PostConstruct
    public void init(){
        LOG.info("++++++++++++++++++++Inside Post Construct Method+++++++++++++++++++");
    }


}
