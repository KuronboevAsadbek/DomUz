package uz.DomUz.service;


import uz.DomUz.model.Housing;

import java.util.List;

public interface HousingService {

    Housing addHousing(Housing housing);

    Housing getHousing(Long id);

    void delete(Long id);

    Housing update(Housing housing);

    List<Housing> getAllHousing();
}
