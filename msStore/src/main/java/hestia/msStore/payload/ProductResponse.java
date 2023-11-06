package hestia.msStore.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private List<ProductDto> content;
    private int PageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

}