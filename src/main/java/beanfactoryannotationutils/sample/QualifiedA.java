package beanfactoryannotationutils.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Emilien
 */
@Component
@Qualifier(QualifierEnum.QUALIFIER_A)
public class QualifiedA implements QualifiedInterface {

    @Override
    public String toString() {
        return QualifierEnum.QUALIFIER_A;
    }
}
