package study.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;
import study.config.autoconfig.EnableMyConfigurationProperties;

public class MyConfigurationPropertiesImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> attr = importingClassMetadata.getAllAnnotationAttributes(
            EnableMyConfigurationProperties.class.getName());
        Class propertyClass = (Class) attr.getFirst("value");
        return new String[] { propertyClass.getName() };
    }
}