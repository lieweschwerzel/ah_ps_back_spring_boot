package net.liewe.ah.service;

import net.liewe.ah.model.Subscription;
import net.liewe.ah.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> getSubscriptions() {
        return  subscriptionRepository.findAll();
    }

    public void createSubscription(Subscription subscription) {
        //check for existing sub with Optional
        Optional<Subscription> subscriptionOptional = subscriptionRepository
                .findSubscriptionByEmailAndProductNameAndUnit(subscription.getEmail(), subscription.getProductName(), subscription.getUnit());
        if (subscriptionOptional.isPresent() ){
            throw new IllegalStateException("Subscription already PRESENT");
        }
        subscriptionRepository.save(subscription);
    }
}
