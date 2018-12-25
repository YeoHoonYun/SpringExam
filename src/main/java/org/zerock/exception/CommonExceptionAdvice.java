package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-26
 * Github : https://github.com/YeoHoonYun
 */
@ControllerAdvice
public class CommonExceptionAdvice {
    //http://localhost:8080/sample/ex04?name=aaa&age=bbb&page=41awqrq
    @ExceptionHandler(Exception.class)
    public String except(Exception ex, Model model){
        System.out.println("Exception ......." + ex.getMessage());
        model.addAttribute("exception", ex);
        System.out.println(model);
        return "error_page";
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex){
        return "custom404";
    }
}
