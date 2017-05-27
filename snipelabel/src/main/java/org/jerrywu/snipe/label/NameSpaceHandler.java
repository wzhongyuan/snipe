package org.jerrywu.snipe.label;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by jerry on 17-5-27.
 */
public class NameSpaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser(BeanType.SERVICE.getName(), new ServiceBeanDefinitionParser());
    }
}

enum BeanType {

    SERVICE("service", "service bean definition");

    private  String name = null;
    private  String desc = null;

    private BeanType(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    public String getName() {
        return name;
    }
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return name;
    }
}
