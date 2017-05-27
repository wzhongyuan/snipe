package org.jerrywu.snipe.label;

import org.jerrywu.snipe.label.util.LabelProcessingException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jerry on 17-5-27.
 */

public class TestLabel {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void testGenericParsing() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("normalParsing.xml");
        Service service = (Service) ac.getBean("normalParsing");
        assert (("normalParsing").equals(service.getName()));
        assert (("snipe").equals(service.getProtocol()));
        assert (("hello").equals(service.getInterfaceRef()));
    }
    @Test
    public void testParsingException() {
        thrown.expect(BeanDefinitionStoreException.class);
        ApplicationContext ac = new ClassPathXmlApplicationContext("parsingException.xml");
        Service service = (Service) ac.getBean("missingFieldParsing");
    }
}