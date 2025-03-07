package com.example.businessrules.rules;

import com.example.businessrules.model.Order;

import java.util.List;

public class FreeVideoRule implements BusinessRule {
    @Override
    public void apply(Order order, List<String> actions) {
        if ("Learning to Ski".equals(order.product())) {
            actions.add("Add free 'First Aid' video to packing slip");
        }
    }
}
