package uz.DomUz.service.imp;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import uz.DomUz.config.NetworkDataService;
import uz.DomUz.dto.FindByPassportDto;
import uz.DomUz.exception.BadRequestException;
import uz.DomUz.exception.NotFoundException;
import uz.DomUz.model.Account;
import uz.DomUz.repository.AccountRepository;
import uz.DomUz.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {


    private final Gson gson = new Gson();
    private final NetworkDataService networkDataService;
    private final static Logger LOG = LoggerFactory.getLogger(AccountServiceImp.class);
    private final AccountRepository accountRepository;


    @Override
    public Account save(Account account, HttpServletRequest httpServletRequest) throws BadRequestException {
        String ClientIP = networkDataService.getClientIPv4Address(httpServletRequest);
        String ClientInfo = networkDataService.getRemoteUserInfo(httpServletRequest);

        if (!accountRepository.existsByDealNumber(account.getDealNumber())) {
            double costOne2 = Double.parseDouble(account.getCostOneSquare()) * Double.parseDouble(account.getSquare());
            account.setTotalAmount(String.valueOf(costOne2));
            double percent = Double.parseDouble(account.getTotalAmount()) * Double.parseDouble(account.getInitialPayment()) / 100;
            account.setAfterPayAmount(String.valueOf(percent));
            LOG.info("New Account Saved \t\t {}", gson.toJson(account));
            LOG.info("Client host : \t\t {}", gson.toJson(ClientInfo));
            LOG.info("Client IP :  \t\t {}", gson.toJson(ClientIP));
            return accountRepository.save(account);
        } else
            LOG.error("Deal Number Is Already Created!");
        throw new BadRequestException("Deal Number Is Already Crated!");

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
    public Account update(Account account, HttpServletRequest httpServletRequest) {
        String ClientIP = networkDataService.getClientIPv4Address(httpServletRequest);
        String ClientInfo = networkDataService.getRemoteUserInfo(httpServletRequest);
        LOG.info("New Account Saved \t\t {}", gson.toJson(account));
        LOG.info("Client host : \t\t {}", gson.toJson(ClientInfo));
        LOG.info("Client IP :  \t\t {}", gson.toJson(ClientIP));
        if (account.getId() == null) {
            throw new NotFoundException("Account not found");
        } else {
            LOG.info("Account  Updated \t\t {}", gson.toJson(account));
            LOG.info("Client host : \t\t {}", gson.toJson(ClientInfo));
            LOG.info("Client IP :  \t\t {}", gson.toJson(ClientIP));
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


    public List<String> search(String name, HttpServletRequest httpServletRequest) {
        String ClientIP = networkDataService.getClientIPv4Address(httpServletRequest);
        String ClientInfo = networkDataService.getRemoteUserInfo(httpServletRequest);
        List<String> list = accountRepository.search(name);

        if (ObjectUtils.isEmpty(list)) {
            LOG.error("Not Found");
            throw new NotFoundException("Not Found " + name);
        } else

            LOG.info("Client host : \t\t {}", gson.toJson(ClientInfo));
        LOG.info("Client IP :  \t\t {}", gson.toJson(ClientIP));
        LOG.info("List found\\t\\t {}", gson.toJson(list));
        return list;
    }
}
