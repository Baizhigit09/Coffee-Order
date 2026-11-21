package kz.baizhik.menuservice.service;

import kz.baizhik.menuservice.model.dto.DrinkRequestDTO;
import kz.baizhik.menuservice.model.dto.DrinkResponseDTO;
import kz.baizhik.menuservice.model.dto.PageResponseDTO;
import kz.baizhik.menuservice.model.entites.Drink;
import org.springframework.data.domain.Pageable;

import javax.naming.ldap.PagedResultsControl;

public interface MenuService {
    PageResponseDTO<DrinkResponseDTO> getAll(Long categoryId, Pageable pageable);

    DrinkResponseDTO getById(Long id);

    DrinkResponseDTO create(DrinkRequestDTO request);

    DrinkResponseDTO update(Long id, DrinkRequestDTO request);


    void delete(Long id);

}
