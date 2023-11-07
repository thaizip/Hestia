package hestia.msStore.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ProductResponse {

    private List<ProductDto> content;
    private int PageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public ProductResponse(List<ProductDto> content, int pageNo, int pageSize, long totalElements, int totalPages, boolean last) {
        this.content = content;
        PageNo = pageNo;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.last = last;
    }
}