package uz.DomUz.service;

import uz.DomUz.dto.FindByPassportDto;
import uz.DomUz.model.Account;

import java.util.List;

public interface AccountService {
    //

    Account save(Account account);

    void delete(Long id);

    Account update(Account account);

    Account getOne(Long id);

    List<Account> getAll();

    List<FindByPassportDto> findByPassportNumber(String passportNumber);

    Account findByAccountName(String accountName);


}
