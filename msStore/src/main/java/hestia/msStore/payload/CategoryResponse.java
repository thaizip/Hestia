package hestia.msStore.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

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

    public CategoryResponse(List<CategoryDto> categoryDtos, int pageNo, int pageSize, long totalElements, int totalPages, boolean last) {
        this.categoryDtos = categoryDtos;
        PageNo = pageNo;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }
}