package uz.DomUz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.DomUz.model.Account;
import uz.DomUz.service.AccountService;

@RequestMapping("/api")
@RestController
public class AccountController {
    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/createacc")
    public ResponseEntity<?> create(@RequestBody Account account){
    return ResponseEntity.ok(accountService.save(account));
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
    public ResponseEntity<?> update(@RequestBody Account account){
        return ResponseEntity.ok(accountService.update(account));
    }

    @GetMapping("/getby")
    public ResponseEntity<?> getByPassportNumber(@RequestParam String passportNumber){
        return ResponseEntity.ok(accountService.findByPassportNumber(passportNumber));
    }

    @GetMapping("/getbyaccountname")
    public ResponseEntity<?> getByAccountName(@RequestParam String accountName){
        return ResponseEntity.ok(accountService.findByAccountName(accountName));
    }
}

