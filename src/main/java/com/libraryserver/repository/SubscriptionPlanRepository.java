package com.libraryserver.repository;

import com.libraryserver.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Integer> {

    @Query(nativeQuery = true, value = "select sp.* from subscription_plan sp order by sp.SubscriptionId desc limit 1")
    SubscriptionPlan getLastSubscriptionId();

}
