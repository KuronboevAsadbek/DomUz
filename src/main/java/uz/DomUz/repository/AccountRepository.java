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

    Account findAccountByName(String accountName);



}
