package uz.DomUz.service.imp;

import org.springframework.stereotype.Service;
import uz.DomUz.dto.FindByPassportDto;
import uz.DomUz.exception.NotFoundException;
import uz.DomUz.model.Account;
import uz.DomUz.repository.AccountRepository;
import uz.DomUz.service.AccountService;

import java.util.ArrayList;
import java.util.List;

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
            accountRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("Account not found");
        }
    }

    @Override
    public Account update(Account account) {

        if (accountRepository.findById(account.getId()).isPresent()){
            Account account1 = accountRepository.findById(account.getId()).get();
        if (account.getAddress() != null) {
            account1.setAddress(account.getAddress());
        }
        if (account.getFloor() != null) {
            account1.setFloor(account.getFloor());
        }
        if (account.getDealDate() != null) {
            account1.setDealDate(account.getDealDate());
        }
        if (account.getInn() != null) {
            account1.setInn(account.getInn());
        }
        if (account.getJshshir() != null) {
            account1.setJshshir(account.getJshshir());
        }
        if (account.getMobileNumber() != null) {
            account1.setMobileNumber(account.getMobileNumber());
        }
        if (account.getPassportNumber() != null) {
            account1.setPassportNumber(account.getPassportNumber());
        }
        if (account.getRoom() != null) {
            account1.setRoom(account.getRoom());
        }
        if (account.getCostOneSquare() != null) {
            account1.setCostOneSquare(account.getCostOneSquare());
        }
        if (account.getTotalAmount() != null) {
            account1.setTotalAmount(account.getTotalAmount());
        }
        if (account.getHomeNumber() != null) {
            account1.setHomeNumber(account.getHomeNumber());
        }
        if (account.getDealNumber() != null) {
            account1.setDealNumber(account.getDealNumber());
        }
        if (account.getLastName() != null) {
            account1.setLastName(account.getLastName());
        }
        if (account.getName() != null) {
            account1.setName(account.getName());
        }
        if (account.getEntranceNumber() != null) {
            account1.setEntranceNumber(account.getEntranceNumber());
        }
        if (account.getDateOfBirth() != null) {
            account1.setDateOfBirth(account.getDateOfBirth());
        }
        if (account.getMarriage() != null) {
            account1.setMarriage(account.getMarriage());
        }
        if (account.getHousing().getId() != null) {
            account1.setHousing(account.getHousing());
        }
        return accountRepository.save(account1);
    }else {
            throw new NotFoundException("Account not found");
        }
    }

    @Override
    public Account getOne(Long id) {
        if (accountRepository.findById(id).isPresent()) {
            return accountRepository.findById(id).get();
        } else {
            throw new NotFoundException("Account not found");
        }
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<FindByPassportDto> findByPassportNumber(String passportNumber) {
        List<Account> accounts = accountRepository.findByPassportNumber(passportNumber);
        List<FindByPassportDto> findByPassportDtos = new ArrayList<>();
        for (Account account : accounts) {
            FindByPassportDto findByPassportDto = new FindByPassportDto();
            findByPassportDto.setId(account.getId());
            findByPassportDto.setName(account.getName());
            findByPassportDto.setLastName(account.getLastName());
            findByPassportDto.setPassportNumber(account.getPassportNumber());
            findByPassportDtos.add(findByPassportDto);
        }
        return findByPassportDtos;

    }

    @Override
    public Account findByAccountName(String accountName) {
        if (accountRepository.findAccountByName(accountName) != null) {
            return accountRepository.findAccountByName(accountName);
        } else {
            throw new NotFoundException("Account not found");
        }

    }
    public List<String> search(String name){
        if (accountRepository.search(name).isEmpty()){
            throw new NotFoundException("Not Found");
        }else
            return accountRepository.search(name);
    }
}
