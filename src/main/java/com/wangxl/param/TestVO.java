package com.wangxl.param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TestVO {

    @NotBlank
    private String msg;

    @NotNull
    private Integer id;


}
