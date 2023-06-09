package uz.DomUz.service;

import uz.DomUz.dto.FindByPassportDto;
import uz.DomUz.exception.BadRequestException;
import uz.DomUz.model.Account;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AccountService {
    //

    Account save(Account account, HttpServletRequest httpServletRequest) throws BadRequestException;

    void delete(Long id);

    Account update(Account account, HttpServletRequest httpServletRequest);

    Account getOne(Long id);

    List<Account> getAll();

    List<FindByPassportDto> findByPassportNumber(String passportNumber);


    List<String> search(String name, HttpServletRequest httpServletRequest);


}
