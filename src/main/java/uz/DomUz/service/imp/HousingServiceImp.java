package uz.DomUz.service.imp;

import org.springframework.stereotype.Service;
import uz.DomUz.exception.NotFoundException;
import uz.DomUz.model.Housing;
import uz.DomUz.repository.HousingRepository;
import uz.DomUz.service.HousingService;

import java.util.List;

@Service
public class HousingServiceImp implements HousingService {

    private final HousingRepository housingRepository;

    public HousingServiceImp(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public Housing addHousing(Housing housing) {
    return housingRepository.save(housing);
    }

    @Override
    public Housing getHousing(Long id) {
        return housingRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        try {
            housingRepository.deleteById(id);

        } catch (Exception e) {
            throw new NotFoundException("House Not found");
        }
    }

    @Override
    public Housing update(Housing housing) {
        housingRepository.findById(housing.getId()).get();
        return housingRepository.save(housing);
    }

    @Override
    public List<Housing> getAllHousing() {
        try {
        return housingRepository.findAll();

        } catch (Exception e) {
            throw new NotFoundException("There is no data");
        }
    }
}
