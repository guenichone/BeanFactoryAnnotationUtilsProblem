package beanfactoryannotationutils.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author Emilien
 */
@Component
@Qualifier(QualifierEnum.QUALIFIER_B)
public class QualifiedB implements QualifiedInterface {

    @Override
    public String toString() {
        return QualifierEnum.QUALIFIER_B;
    }
}
