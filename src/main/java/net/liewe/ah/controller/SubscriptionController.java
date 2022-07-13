package net.liewe.ah.controller;

import net.liewe.ah.model.Subscription;
import net.liewe.ah.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    public List<Subscription> getSubscriptions() {
        return subscriptionService.getSubscriptions();
    }

    //return all subscription from user (email)
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public List<Subscription> getUserSubscriptions(@PathVariable("email") String email) {
        return subscriptionService.getUserSubscriptions(email);
    }

    //POST create subscription
    @PostMapping(value = "/post")
    public void createSubscription(@RequestBody Subscription subscription) {
        subscriptionService.createSubscription(subscription);
    }

    //DELETE subscription
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteSubscription(@PathVariable("id") Long id){
    subscriptionService.deleteSubscription(id);
    }

}

