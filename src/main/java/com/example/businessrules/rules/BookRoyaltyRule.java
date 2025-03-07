package com.example.businessrules.rules;

import com.example.businessrules.model.Order;

import java.util.List;

public class BookRoyaltyRule implements BusinessRule {
    @Override
    public void apply(Order order, List<String> actions) {
        actions.add("Generate duplicate packing slip for royalty department");
    }
}
