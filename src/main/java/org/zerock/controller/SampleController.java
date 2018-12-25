package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cjswo9207u@gmail.com on 2018-12-25
 * Github : https://github.com/YeoHoonYun
 */

@Controller
@RequestMapping("/sample/*")
public class SampleController {

    private final static Logger log = Logger.getGlobal();

    @RequestMapping("")
    public void basic(){
        System.out.println("test!!!!!!");
    }

    @RequestMapping(value="/basic",method= {RequestMethod.GET, RequestMethod.POST})
    public void basicGet(){
        System.out.println("basic get .....................");
    }
    @GetMapping("/basicOnlyGet")
    public void baicGet2(){
        System.out.println("basic get only get......................");
    }

    //localhost:8080/sample/ex01?name=AAA&age=10
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto){
        System.out.println("" + dto);
        return "ex01";
    }

    //http://localhost:8080/sample/ex02?name=AAA&age10
    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age){
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        return "ex02";
    }

    //경로/sample/ex02List?ids=111&ids=222&ids=333
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids")ArrayList<String> ids){
        System.out.println(ids);
        return "ex02List";
    }

    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids){
        System.out.println("array ids : " + Arrays.toString(ids));

        return "ex02Array";
    }

    //http://localhost:8080/sample/ex02Bean?list%5B0%5D.name=aaa&list%5B1%5D.name=BBB&list%5B2%5D.name=CCC
    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list){
        System.out.println("list dtos: " + list);

        return "ex02Bean";
    }
}
