package uz.DomUz.service.imp;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import uz.DomUz.dto.FindByPassportDto;
import uz.DomUz.exception.NotFoundException;
import uz.DomUz.model.Account;
import uz.DomUz.repository.AccountRepository;
import uz.DomUz.service.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImp implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public Account save(Account account) {
        double costOne2 = Double.parseDouble(account.getCostOneSquare()) * Double.parseDouble(account.getSquare());
        account.setTotalAmount(String.valueOf(costOne2));
        double percent = Double.parseDouble(account.getTotalAmount()) * Double.parseDouble(account.getInitialPayment()) / 100;
        account.setAfterPayAmount(String.valueOf(percent));
        return accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        try {
            accountRepository.deleteById(id); //delete with cascade fix this problem
        } catch (Exception e) {
            throw new NotFoundException("Account not found");
        }
    }

    @Override
    public Account update(Account account) {
        if (account.getId() == null) {
            throw new NotFoundException("Account not found");
        } else {
            return accountRepository.save(account);
        }
    }

    @Override
    public Account getOne(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found"));
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<FindByPassportDto> findByPassportNumber(String passportNumber) {
        List<Account> accounts = accountRepository.findByPassportNumber(passportNumber);
        return accounts.stream()
                .map(account -> {
                    FindByPassportDto findByPassportDto = new FindByPassportDto();
                    findByPassportDto.setId(account.getId());
                    findByPassportDto.setName(account.getName());
                    findByPassportDto.setLastName(account.getLastName());
                    findByPassportDto.setPassportNumber(account.getPassportNumber());
                    return findByPassportDto;
                })
                .collect(Collectors.toList());

    }

    @Override
    public Account findByAccountName(String accountName) {
        if (accountRepository.findAccountByName(accountName) != null) {
            return accountRepository.findAccountByName(accountName);
        } else {
            throw new NotFoundException("Account not found");
        }

    }

    public List<String> search(String name) {
        List<String> list = accountRepository.search(name);

        if (ObjectUtils.isEmpty(list)) {
            throw new NotFoundException("Not Found");
        } else
            return list;
    }
}
