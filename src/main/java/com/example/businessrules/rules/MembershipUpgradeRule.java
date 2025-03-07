package com.example.businessrules.rules;

import com.example.businessrules.model.Order;

import java.util.List;

public class MembershipUpgradeRule implements BusinessRule {
    @Override
    public void apply(Order order, List<String> actions) {
        actions.add("Upgrade membership");
        actions.add("Send upgrade email");
    }
}
