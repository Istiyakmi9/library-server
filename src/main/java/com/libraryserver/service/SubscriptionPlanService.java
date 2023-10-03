package com.libraryserver.service;

import com.libraryserver.entity.SubscriptionPlan;

import java.util.ArrayList;
import java.util.Optional;

public interface SubscriptionPlanService {

    public String addSubscriptionPlanService(SubscriptionPlan subscriptionPlan);
    public SubscriptionPlan updateSubscriptionPlanService(SubscriptionPlan subscriptionPlan, int subscriptionPlanId) throws Exception;
    public ArrayList<SubscriptionPlan> getAllSubscriptionPlanService();
    public Optional<SubscriptionPlan> getSubscriptionPlanBySubscriptionIdService(int subscriptionId);

}
