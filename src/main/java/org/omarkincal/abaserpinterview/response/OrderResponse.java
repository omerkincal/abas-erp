package org.omarkincal.abaserpinterview.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private int id;
    private int orderNo;

    //public CategoryRequest(@JsonProperty("categoryName") String categoryName){
    //  this.categoryName=categoryName;
    //}
}
