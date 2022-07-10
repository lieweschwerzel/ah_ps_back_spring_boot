package net.liewe.ah.controller;

import net.liewe.ah.model.Subscription;
import net.liewe.ah.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/subs")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<Subscription> getProducts() {
        return subscriptionService.getSubscriptions();
    }

    @PostMapping
    public void createSubscription(@RequestBody Subscription subscription){
        subscriptionService.createSubscription(subscription);
    }
}
