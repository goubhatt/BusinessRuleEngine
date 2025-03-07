package com.example.businessrules.engine;

import com.example.businessrules.model.Order;
import com.example.businessrules.model.PaymentType;
import com.example.businessrules.rules.*;

import java.util.*;

public class BusinessRuleEngine {
    private final Map<PaymentType, List<BusinessRule>> ruleMap = new HashMap<>();

    public BusinessRuleEngine() {
        ruleMap.put(PaymentType.PHYSICAL_PRODUCT, Arrays.asList(new PackingSlipRule(), new CommissionPaymentRule()));
        ruleMap.put(PaymentType.BOOK, Arrays.asList(new PackingSlipRule(), new BookRoyaltyRule(), new CommissionPaymentRule()));
        ruleMap.put(PaymentType.MEMBERSHIP, Collections.singletonList(new MembershipActivationRule()));
        ruleMap.put(PaymentType.MEMBERSHIP_UPGRADE, Collections.singletonList(new MembershipUpgradeRule()));
        ruleMap.put(PaymentType.VIDEO, Collections.singletonList(new FreeVideoRule()));
    }

    public List<String> processOrder(Order order) {
        List<String> actions = new ArrayList<>();
        if (ruleMap.containsKey(order.paymentType())) {
            for (BusinessRule rule : ruleMap.get(order.paymentType())) {
                rule.apply(order, actions);
            }
        }
        return actions;
    }
}
