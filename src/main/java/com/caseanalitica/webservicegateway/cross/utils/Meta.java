package com.caseanalitica.webservicegateway.cross.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meta {

    private Integer page;
    private Integer pageSize;
    private String previousPage;
    private String nextPage;
    private Integer totalRecords;

}
