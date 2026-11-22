package kz.baizhik.menuservice.controllers;

import jakarta.validation.Valid;
import kz.baizhik.menuservice.model.dto.DrinkRequestDTO;
import kz.baizhik.menuservice.model.dto.DrinkResponseDTO;
import kz.baizhik.menuservice.model.dto.PageResponseDTO;
import kz.baizhik.menuservice.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping
    public PageResponseDTO<DrinkResponseDTO> getAll(
            @RequestParam(required = false) Long categoryId,
            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return menuService.getAll(categoryId, pageable);
    }

    @GetMapping("/{id}")
    public DrinkResponseDTO getById(@PathVariable Long id) {
        return menuService.getById(id);
    }

    @PostMapping
    public ResponseEntity<DrinkResponseDTO> create(@Valid @RequestBody DrinkRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuService.create(request));
    }

    @PutMapping("/{id}")
    public DrinkResponseDTO update(@PathVariable Long id, @Valid @RequestBody DrinkRequestDTO request) {
        return menuService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
