package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private String uuid;
    private String productName;
    private Integer qty;
    private LocalDate createdDate;
}
