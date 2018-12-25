package org.zerock.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-26
 * Github : https://github.com/YeoHoonYun
 */
@Data
public class SampleDTOList {
    public List<SampleDTO> list;

    public SampleDTOList() {
        list = new ArrayList<>();
    }
}
