package com.example.businessrules;

import com.example.businessrules.engine.BusinessRuleEngine;
import com.example.businessrules.model.Order;
import com.example.businessrules.model.PaymentType;

public class BusinessRulesApp {
    public static void main(String[] args) {
        BusinessRuleEngine engine = new BusinessRuleEngine();
        Order order1 = new Order(PaymentType.BOOK, "Some Book");
        Order order2 = new Order(PaymentType.VIDEO, "Learning to Ski");

        System.out.println("Book Order Actions: " + engine.processOrder(order1));
        System.out.println("Video Order Actions: " + engine.processOrder(order2));
    }
}
