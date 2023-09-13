package com.caseanalitica.webservicegateway.cross.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data<T> {

    private List<T> data;

}
