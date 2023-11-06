package hestia.msStore.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class CategoryResponse {

    private List<CategoryDto> categoryDtos;

    private int PageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

}