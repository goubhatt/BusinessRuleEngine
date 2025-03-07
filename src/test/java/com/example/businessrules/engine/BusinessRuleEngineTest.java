package com.example.businessrules.engine;

import com.example.businessrules.model.Order;
import com.example.businessrules.model.PaymentType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class BusinessRuleEngineTest {
    @Test
    void testPhysicalProductOrder() {
        BusinessRuleEngine engine = new BusinessRuleEngine();
        Order order = new Order(PaymentType.PHYSICAL_PRODUCT, "Laptop");
        List<String> actions = engine.processOrder(order);
        assertTrue(actions.contains("Generate packing slip for shipping"));
        assertTrue(actions.contains("Generate commission payment to agent"));
    }

    @Test
    void testBookOrder() {
        BusinessRuleEngine engine = new BusinessRuleEngine();
        Order order = new Order(PaymentType.BOOK, "Java Programming");
        List<String> actions = engine.processOrder(order);
        assertTrue(actions.contains("Generate packing slip for shipping"));
        assertTrue(actions.contains("Generate duplicate packing slip for royalty department"));
        assertTrue(actions.contains("Generate commission payment to agent"));
    }

    @Test
    void testMembershipActivation() {
        BusinessRuleEngine engine = new BusinessRuleEngine();
        Order order = new Order(PaymentType.MEMBERSHIP, "Premium Membership");
        List<String> actions = engine.processOrder(order);
        assertTrue(actions.contains("Activate membership"));
        assertTrue(actions.contains("Send activation email"));
    }

    @Test
    void testMembershipUpgrade() {
        BusinessRuleEngine engine = new BusinessRuleEngine();
        Order order = new Order(PaymentType.MEMBERSHIP_UPGRADE, "Upgrade to Gold");
        List<String> actions = engine.processOrder(order);
        assertTrue(actions.contains("Upgrade membership"));
        assertTrue(actions.contains("Send upgrade email"));
    }

    @Test
    void testFreeVideo() {
        BusinessRuleEngine engine = new BusinessRuleEngine();
        Order order = new Order(PaymentType.VIDEO, "Learning to Ski");
        List<String> actions = engine.processOrder(order);
        assertTrue(actions.contains("Add free 'First Aid' video to packing slip"));
    }

}
