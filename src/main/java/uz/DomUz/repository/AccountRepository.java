package uz.DomUz.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import uz.DomUz.model.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //
    List<Account> findByPassportNumber(String passportNumber);

    Boolean existsByDealNumber(String dealNumber);

    Account findByDealNumber(String accountName);

    @Query(value = "select name from account where name. like %:name%", nativeQuery = true)
    public List<String> search(String name);

}
