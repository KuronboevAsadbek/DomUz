package uz.DomUz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.DomUz.model.Housing;
import uz.DomUz.service.HousingService;

@RestController
@RequestMapping("/api")
public class HousingController {
    private final HousingService housingService;

    public HousingController(HousingService housingService) {
        this.housingService = housingService;
    }

    @PostMapping("/addhousing")
    public ResponseEntity<?> addHousing(@RequestBody Housing housing){
        return ResponseEntity.ok(housingService.addHousing(housing));
    }

    @GetMapping("/getallhousing")
    public ResponseEntity<?> getAllHousing(){
        return ResponseEntity.ok(housingService.getAllHousing());
    }

    @GetMapping("/getonehousing/{id}")
    public ResponseEntity<?> getOneHousing(@PathVariable Long id){
        return ResponseEntity.ok(housingService.getHousing(id));
    }

    @DeleteMapping("/deletehousing/{id}")
    public ResponseEntity<?> deleteHousing(@PathVariable Long id){
        housingService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/updatehousing")
    public ResponseEntity<?> updateHousing(@RequestBody Housing housing){
        return ResponseEntity.ok(housingService.update(housing));
    }
}
