package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import java.text.SimpleDateFormat;
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

//    //InitBinder
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor((java.util.Date.class), new CustomDateEditor(dateFormat, false));
//    }

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

    //@InitBinder 사용 String 값을 Date 값으로 변환
    //http://localhost:8080/sample/ex3?title=test&dueDate=2018-01-01
    @GetMapping("/ex03")
    public String ex03(TodoDTO todo){
        System.out.println("todo: " + todo);
        return "ex03";
    }

    //@ModelAttribute 어노테이션
    //http://localhost:8080/sample/ex04?name=aaa&age=11&page=9
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page){
        System.out.println("dto : " + dto);
        System.out.println("page : " + page);
        return "/sample/ex04";
    }
    /*
        Controller 리턴 타입
        String : jsp를 이용하는 경우에는 jsp파일의 경로와 파일이름을 나타내기 위해서 사용합니다.
        void : 호출하는 URL과 동일한 이름의 jsp를 의미합니다.
        VO, DTO 타입 : 주로 JSON 타입의 데이터를 만들어서 반환하는 용도로 사용합니다.
        ResponseEntity 타입 : response 할때 Http 헤더 정보와 내용을 가공하는 용도로 사용합니다.
        Model, ModelAndView : Model로 데이터를 반환하거나 화면까지 같이 지정하는 경우에 사용합니다.(최근에는 많이 사용하지 않습니다.)
        HttpHeaders : 응답에 내용 없이 Http 헤더메시지만 전달하는 용도로 사용합니다.
     */
    //void 타입
    @GetMapping("/ex05")
    public void ex05(){
        System.out.println("/ex05.............");
    }

    // 객체 타입
    @GetMapping("/ex06")
    public @ResponseBody SampleDTO ex06(){
        System.out.println("/ex06...............");
        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");
        return dto;
    }

    @GetMapping("/ex07")
    public ResponseEntity<String> ex07(){
        System.out.println("/ex07......");

        String msg = "{\"name\" : \"홍길동\"}";
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, header, HttpStatus.OK);

    }
    @GetMapping("/exUpload")
    public void exUpload(){
        System.out.println("/exUpload..............");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files){
        files.forEach(file -> {
            System.out.println("----------------------------");
            System.out.println("name:" + file.getOriginalFilename());
            System.out.println("size : " + file.getSize());
        });
    }
}
