package com.example.businessrules.rules;

import com.example.businessrules.model.Order;

import java.util.List;

public class MembershipActivationRule implements BusinessRule {
    @Override
    public void apply(Order order, List<String> actions) {
        actions.add("Activate membership");
        actions.add("Send activation email");
    }
}
