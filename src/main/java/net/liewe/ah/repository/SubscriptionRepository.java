package net.liewe.ah.repository;

import net.liewe.ah.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long > {
    //@Query("SELECT s FROM Subscription s WHERE s.email = ?1 AND s.productName = ?1 AND s.unit = ?1")
    Optional<Subscription> findSubscriptionByEmailAndProductNameAndUnit(String email, String productName, String unit);

    Optional<Subscription> findSubscriptionById(String id);

    void deleteById(String id);

    List<Subscription> findByEmail(String email);

}
