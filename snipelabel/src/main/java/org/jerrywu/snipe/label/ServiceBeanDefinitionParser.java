package org.jerrywu.snipe.label;

import org.jerrywu.snipe.label.util.ErrorMSG;
import org.jerrywu.snipe.label.util.LabelProcessingException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by jerry on 17-5-27.
 */
public class ServiceBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    protected Class getBeanClass(Element element) {
        return Service.class;
    }

    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String id = element.getAttribute(ServiceAttribute.ID.getBeanAttribute());
        String name = element.getAttribute(ServiceAttribute.NAME.getBeanAttribute());
        String protocol = element.getAttribute(ServiceAttribute.PROTOCOL.getBeanAttribute());
        String interfaceRef = element.getAttribute(ServiceAttribute.INTERFACE.getBeanAttribute());

        if (!StringUtils.hasText(id)) {
            throw  new LabelProcessingException(ErrorMSG.SERVICE_FIELDS_MISSING + " : id ");
        }
        bean.addPropertyValue(ServiceAttribute.ID.getClsAttribute(), id);

        if (StringUtils.hasText(name)) {
            bean.addPropertyValue(ServiceAttribute.NAME.getClsAttribute(), name);
        } else {
            //overwrite with id instead
            bean.addPropertyValue(ServiceAttribute.NAME.getClsAttribute(), id);
        }
        if (StringUtils.hasText(protocol)) {
            bean.addPropertyValue(ServiceAttribute.PROTOCOL.getClsAttribute(), protocol);
        }

        if (StringUtils.hasText(interfaceRef)) {
            bean.addPropertyValue(ServiceAttribute.INTERFACE.getClsAttribute(), interfaceRef);
        }
    }
}
enum ServiceAttribute {
    ID("id","id"),
    NAME("name","name"),
    PROTOCOL("protocol","protocol"),
    INTERFACE("interface", "interfaceRef");
    private String beanAttribute;
    private String clsAttribute;
    private ServiceAttribute(String beanAttribute, String clsAttribute) {
        this.beanAttribute = beanAttribute;
        this.clsAttribute = clsAttribute;
    }
    public String getBeanAttribute() {
        return beanAttribute;
    }

    public String getClsAttribute() {
        return clsAttribute;
    }
}
