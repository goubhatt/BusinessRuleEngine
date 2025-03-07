package com.example.businessrules.rules;

import com.example.businessrules.model.Order;

import java.util.List;

public interface BusinessRule {
    void apply(Order order, List<String> actions);
}
