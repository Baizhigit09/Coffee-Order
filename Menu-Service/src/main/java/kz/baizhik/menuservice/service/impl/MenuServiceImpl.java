package kz.baizhik.menuservice.service.impl;

import jakarta.transaction.Transactional;
import kz.baizhik.menuservice.exceptions.CategoryNotFoundException;
import kz.baizhik.menuservice.exceptions.DrinkNotFoundException;
import kz.baizhik.menuservice.mappers.DrinkMapper;
import kz.baizhik.menuservice.model.dto.DrinkRequestDTO;
import kz.baizhik.menuservice.model.dto.DrinkResponseDTO;
import kz.baizhik.menuservice.model.dto.PageResponseDTO;
import kz.baizhik.menuservice.model.entites.Category;
import kz.baizhik.menuservice.model.entites.Drink;
import kz.baizhik.menuservice.repositories.CategoryRepository;
import kz.baizhik.menuservice.repositories.DrinkRepository;
import kz.baizhik.menuservice.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final DrinkRepository drinkRepository;
    private final CategoryRepository categoryRepository;
    private final DrinkMapper mapper;

    @Override
    @Transactional
    public PageResponseDTO<DrinkResponseDTO> gatAll(Long categoryId, Pageable pageable) {
        Page<Drink> page = (categoryId == null)
                ? drinkRepository.findAll(pageable)
                : drinkRepository.findByCategoryId(categoryId, pageable);
        return PageResponseDTO.from(page.map(mapper::toResponse));
    }

    @Override
    @Transactional
    public DrinkResponseDTO getById(Long id) {
        return drinkRepository.findById(id).map(mapper::toResponse)
                .orElseThrow(() -> new DrinkNotFoundException(id));
    }

    @Override
    @Transactional
    public DrinkResponseDTO create(DrinkRequestDTO request) {
        Drink drink = new Drink();
        apply(drink, request);
        return mapper.toResponse(drinkRepository.save(drink));
    }

    @Override
    public DrinkResponseDTO update(Long id, DrinkRequestDTO request) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new DrinkNotFoundException(id));
        apply(drink, request);
        return mapper.toResponse(drink);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!drinkRepository.existsById(id)) {
            throw new DrinkNotFoundException(id);
        }
        drinkRepository.deleteById(id);
    }

    private void apply(Drink drink, DrinkRequestDTO r) {
        Category category = categoryRepository.findById(r.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException(r.categoryId()));
        drink.setName(r.name().trim());
        drink.setDescription(r.description());
        drink.setPrice(r.price());
        drink.setAvailable(r.available() == null || r.available());
        drink.setCategory(category);
    }
}
