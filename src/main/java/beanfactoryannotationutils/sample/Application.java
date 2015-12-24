package beanfactoryannotationutils.sample;

import java.lang.annotation.Annotation;
import java.util.Map;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author Emilien
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        ListableBeanFactory beanFactory = ctx.getBeanFactory();
        
        // This is working ... (@Autowired with @Qualifier(...) too)
        Map<String, QualifiedInterface> qualifiedBeans = beanFactory.getBeansOfType(QualifiedInterface.class);
        System.out.println("Existing qualified beans ...");
        for (QualifiedInterface qualifiedBean : qualifiedBeans.values()) {
            System.out.println(" " + qualifiedBean.toString());
            for (Annotation annotation : qualifiedBean.getClass().getAnnotations()) {
                System.out.println(" - " + annotation.toString());
            }
        }
        
        // This is working too ...
        Map<String, Object> qualifiedBeansFromCtx = ctx.getBeansWithAnnotation(Qualifier.class);
        System.out.println("Existing qualified beans from context ...");
        for (Object qualifiedBean : qualifiedBeansFromCtx.values()) {
            System.out.println(" " + qualifiedBean.toString());
            for (Annotation annotation : qualifiedBean.getClass().getAnnotations()) {
                System.out.println(" - " + annotation.toString());
            }
        }
        
        // This is not ...
        QualifiedInterface processor = BeanFactoryAnnotationUtils.qualifiedBeanOfType(
            beanFactory, QualifiedInterface.class, QualifierEnum.QUALIFIER_A);
        
        System.out.println("The selected processor should be A " + processor);
    }
    
}
