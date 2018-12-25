package org.zerock.controller;

import jdk.internal.instrumentation.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-25
 * Github : https://github.com/YeoHoonYun
 */
@Controller
public class controller {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Locale locale, Model model){
//        Logger logger = null;
//        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);
//        model.addAllAttributes("serverTime", formattedDate)
        return "index";

        // redirect : 리다이렉트 방식으로 처리하는 경우
        // forward : 포워드 방식으로 처리하는 경우
    }
}