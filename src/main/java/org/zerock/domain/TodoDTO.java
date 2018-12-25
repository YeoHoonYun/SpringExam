package org.zerock.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-26
 * Github : https://github.com/YeoHoonYun
 */
@Data
public class TodoDTO {
    private String title;

    //Date 타입을 이렇게 변환도 가능
    //http://localhost:8080/sample/ex03?title=test&dueDate=2018/01/01
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dueDate;
}
