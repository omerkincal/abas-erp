package org.omarkincal.abaserpinterview.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int id;
    private int orderNo;

    //public CategoryRequest(@JsonProperty("categoryName") String categoryName){
    //  this.categoryName=categoryName;
    //}
}
