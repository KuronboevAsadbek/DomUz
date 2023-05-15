package uz.DomUz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.DomUz.model.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //
    List<Account> findByPassportNumber(String passportNumber);

    Account findAccountByName(String accountName);

}
