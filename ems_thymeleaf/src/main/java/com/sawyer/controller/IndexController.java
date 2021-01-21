package com.sawyer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * thymeleaf所有操作都需要通过controller实现跳转
 * */
@Controller
public class IndexController {
    //主地址，不可以直接访问登录地址，需要从主地址跳转过去
    @GetMapping(value = "/index")
    public String toIndex() {
        return "ems/login";
    }

    //跳转到注册页面
    @GetMapping(value = "/toRegister")
    public String toRegister() {
        return "ems/regist";
    }

    //跳转到添加页面
    @GetMapping(value = "toSave")
    public String toSave() {
        return "ems/addEmp";
    }
}
