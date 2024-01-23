package org.omarkincal.abaserpinterview.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private int orderNo;

    //public CategoryRequest(@JsonProperty("categoryName") String categoryName){
    //  this.categoryName=categoryName;
    //}
}
