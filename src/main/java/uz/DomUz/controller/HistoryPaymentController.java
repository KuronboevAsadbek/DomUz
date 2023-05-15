package uz.DomUz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.DomUz.model.HistoryPayment;
import uz.DomUz.service.HistoryPaymentService;

@RestController
@RequestMapping("/api")
public class HistoryPaymentController {
    private final HistoryPaymentService historyPaymentService;

    public HistoryPaymentController(HistoryPaymentService historyPaymentService) {
        this.historyPaymentService = historyPaymentService;
    }

    @PostMapping("/addhistory")
    public ResponseEntity<?> addHistory(@RequestBody HistoryPayment historyPayment){
        return ResponseEntity.ok(historyPaymentService.addHistoryPayment(historyPayment));
    }

    @GetMapping("/getallhistory")
    public ResponseEntity<?> getAllHistory(){
        return ResponseEntity.ok(historyPaymentService.getAllHistoryPayment());
    }

    @PutMapping("/updatehistory")
    public ResponseEntity<?> updateHistory(@RequestBody HistoryPayment historyPayment){
        return ResponseEntity.ok(historyPaymentService.update(historyPayment));
    }

    @DeleteMapping("/deletehistory/{id}")
    public ResponseEntity<?> deleteHistory(@PathVariable Long id){
        historyPaymentService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/sumallhistory/{id}")
    public ResponseEntity<?> sumAllHistory(@PathVariable Long id){
        return ResponseEntity.ok(historyPaymentService.sumAllHistoryPaymentByAccountId(id));
    }

}
