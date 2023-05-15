package uz.DomUz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.DomUz.model.HistoryPayment;

public interface HistoryPaymentRepository extends JpaRepository<HistoryPayment, Long> {
}