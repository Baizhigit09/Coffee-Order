package kz.baizhik.menuservice.model.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageResponseDTO<T>(
        List<T> content,
        int page,
        int size,
        long totalElements,
        int totalPages
) {
    public static <T> PageResponseDTO<T> from(Page<T> p) {
        return new PageResponseDTO<>(
                p.getContent(),
                p.getNumber(),
                p.getSize(),
                p.getTotalElements(),
                p.getTotalPages()
        );

    }
}
