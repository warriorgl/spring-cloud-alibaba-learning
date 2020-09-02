package com.alicloud.api.object;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class TestObject implements Serializable {

    private Long id;

    private String name;

    private String desc;
}
