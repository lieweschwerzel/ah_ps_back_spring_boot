package net.liewe.ah.controller;

import net.liewe.ah.model.Subscription;
import net.liewe.ah.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    //return all subscriptions from db in a List
    @GetMapping
    public List<Subscription> getProducts() {
        return subscriptionService.getSubscriptions();
    }

    //POST create subscription
    @PostMapping
    public void createSubscription(@RequestBody Subscription subscription) {
        subscriptionService.createSubscription(subscription);
    }

    //DELETE subscription
    @RequestMapping(value = "/{email}/{product_name}}/{unit}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteSubscription(@PathVariable("email") String email, @PathVariable("product_name") String productName, @PathVariable("unit") String unit){
    subscriptionService.deleteSubscription(email, productName, unit);
    }

}

