package io.dhmin.drools;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

class DroolsTest {
    
    @Test
    void shouldAnswerWithTrue() {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();

        KieSession session = kc.newKieSession("DroolsTest");

        DroolsData data = new DroolsData();
        data.setData1("data1");
        session.insert(data);

        int firedRuleCnt = session.fireAllRules();

        assertTrue(firedRuleCnt == 1);
        assertTrue(data.getData3() != null);
    }

}
