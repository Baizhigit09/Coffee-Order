package kz.baizhik.menuservice.controllers;

import kz.baizhik.menuservice.model.dto.DrinkResponseDTO;
import kz.baizhik.menuservice.model.dto.PageResponseDTO;
import kz.baizhik.menuservice.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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


}
