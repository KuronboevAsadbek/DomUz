package uz.DomUz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.DomUz.exception.BadRequestException;
import uz.DomUz.model.Account;
import uz.DomUz.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RequestMapping("/api")
@RestController
public class AccountController {
    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/createacc")
    public ResponseEntity<?> create(@RequestBody Account account, HttpServletRequest httpServletRequest) throws BadRequestException {
    return ResponseEntity.ok(accountService.save(account, httpServletRequest));
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getOne(id));

    }

    @DeleteMapping("/deleteacc/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        accountService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(accountService.getAll());
    }

    @PutMapping("/updateacc")
    public ResponseEntity<?> update(@RequestBody Account account, HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(accountService.update(account, httpServletRequest));
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String name, HttpServletRequest httpServletRequest){
        return ResponseEntity.ok(accountService.search(name, httpServletRequest));
    }

}

