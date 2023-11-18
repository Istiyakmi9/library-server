package com.libraryserver.serviceImpl;

import com.libraryserver.entity.SubscriptionPlan;
import com.libraryserver.repository.SubscriptionPlanRepository;
import com.libraryserver.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {

    @Autowired
    SubscriptionPlanRepository subscriptionPlanRepository;


    public String addSubscriptionPlanService(SubscriptionPlan subscriptionPlan) throws Exception {
        java.util.Date utilDate = new Date();
        var date = new Timestamp(utilDate.getTime());
        var lastSubscriptionId = this.subscriptionPlanRepository.getLastSubscriptionId();
        if (lastSubscriptionId == null){
            subscriptionPlan.setSubscriptionId(1);
        }else {
            subscriptionPlan.setSubscriptionId(lastSubscriptionId.getSubscriptionId()+1);
        }
        subscriptionPlan.setCreatedOn(date);
        subscriptionPlan.setLibraryId(1);
//         validateSubscriptionAmount(subscriptionPlan);
        this.subscriptionPlanRepository.save(subscriptionPlan);

        return "New Subscription Plan has been added";
    }

    private void validateSubscriptionAmount(SubscriptionPlan subscriptionPlan) throws Exception {
        BigDecimal amount;
        if (subscriptionPlan.isMonthlySubscription()) {
            var month = subscriptionPlan.getNumberOfMonths();
            var monthlyAmount = subscriptionPlan.getMonthlyAmount();
            amount = monthlyAmount.multiply(BigDecimal.valueOf(month));
        } else {
            var hours = subscriptionPlan.getNumberOfHours();
            var hourlylyAmount = subscriptionPlan.getHourlyAmount();
            amount = hourlylyAmount.multiply(BigDecimal.valueOf(hours));
        }
        if (!amount.equals(subscriptionPlan.getFinalAmountPerMonth()))
            throw new Exception("Final amount not match");
    }


    public SubscriptionPlan updateSubscriptionPlanService(SubscriptionPlan subscriptionPlan, int subscriptionId) throws Exception {
        Date utilDate = new Date();
        var date = new Timestamp(utilDate.getTime());
        Optional<SubscriptionPlan> result = this.subscriptionPlanRepository.findById(subscriptionId );
        if (result.isEmpty()){
            throw new Exception(" SubscriptionPlanId does not exist");
        }
        SubscriptionPlan existingSubscriptionPlan = result.get();
        existingSubscriptionPlan.setSubscriptionName(subscriptionPlan.getSubscriptionName());
        existingSubscriptionPlan.setSubscriptionDescription(subscriptionPlan.getSubscriptionDescription());
        existingSubscriptionPlan.setMonthlySubscription(subscriptionPlan.isMonthlySubscription());
        existingSubscriptionPlan.setNumberOfMonths(subscriptionPlan.getNumberOfMonths());
        existingSubscriptionPlan.setMonthlyAmount(subscriptionPlan.getMonthlyAmount());
        existingSubscriptionPlan.setHourlySubscription(subscriptionPlan.isHourlySubscription());
        existingSubscriptionPlan.setHourlyAmount(subscriptionPlan.getHourlyAmount());
        existingSubscriptionPlan.setNumberOfHours(subscriptionPlan.getNumberOfHours());
        existingSubscriptionPlan.setFinalAmountPerMonth(subscriptionPlan.getFinalAmountPerMonth());
        existingSubscriptionPlan.setUpdatedOn(date);
        existingSubscriptionPlan.setUpdatedBy(1L);
        this.subscriptionPlanRepository.save(existingSubscriptionPlan);
        return existingSubscriptionPlan;
    }

    public ArrayList<SubscriptionPlan> getAllSubscriptionPlanService() {
        List<SubscriptionPlan> result = this.subscriptionPlanRepository.findAll();
        return (ArrayList<SubscriptionPlan>) result;
    }

    public Optional<SubscriptionPlan> getSubscriptionPlanBySubscriptionIdService(int subscriptionId) {
        Optional<SubscriptionPlan> result = this.subscriptionPlanRepository.findById(subscriptionId);
        return result;
    }
}
