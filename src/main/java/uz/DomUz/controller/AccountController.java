package uz.DomUz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.DomUz.exception.BadRequestException;
import uz.DomUz.model.Account;
import uz.DomUz.service.AccountService;

import java.util.Locale;

@RequestMapping("/api")
@RestController
public class AccountController {
    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/createacc")
    public ResponseEntity<?> create(@RequestBody Account account) throws BadRequestException {
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

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String name){
        return ResponseEntity.ok(accountService.search(name));
    }

}

