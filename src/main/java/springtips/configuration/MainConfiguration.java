package springtips.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

// Create Spring Facet and add this class to new fileset --> gutter icons appear
@Configuration

// includes ScannedConfiguration
@ComponentScan("springtips.configuration.scanned.*")
//@MyComponentScan(myPackagesAreListedHere = "springtips.T01_unmappedConfiguration.scanned.*")

@Import(ImportedConfig.class)
@ImportResource("importResource.xml")

@Profile("mainProfile")
//@Profile("customProfile")
public class MainConfiguration {

    // --> ScannedConfiguration
    @Autowired
    private Long autowiredLongBean;

    @Bean(name = "customName")
    @Description("Some description for this bean.")
    public String beanFromMainConfiguration() {
        return "Hi";

        // Generate->@Autowired Dependency
//        return "Hi" + environment.getProperty("user.name");
    }

    @Bean
    public Integer myIntegerBean() {
        return 2;
    }
}