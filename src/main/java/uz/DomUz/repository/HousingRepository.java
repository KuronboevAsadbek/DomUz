package uz.DomUz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.DomUz.model.Housing;

public interface HousingRepository extends JpaRepository<Housing, Long> {
}