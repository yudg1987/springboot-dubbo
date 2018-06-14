package com.boot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.domain.User;
import com.boot.bo.ToClickHouseBo;
import com.boot.service.TestService;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class TestController {
    @Reference(version = "1.0")
    private TestService testService;

    @GetMapping("hello")
    public String hello() {
        return testService.sayHello("Hello springboot and dubbo!");
    }

    @GetMapping("user")
    public User user() {
        return testService.findUser();
    }

    @GetMapping("getclk")
    public ToClickHouseBo getclk(HttpServletRequest request, Model model) {
        int idColumn = Integer.parseInt(request.getParameter("id"));
        return testService.findRecord(idColumn);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String postUser(@ModelAttribute ToClickHouseBo bo) {
        //this.testService.deleteById(5);
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        this.testService.addRecord(bo);
        return "success";
    }

    @RequestMapping(value = "getpage", method = RequestMethod.POST)
    public PageInfo<ToClickHouseBo> getpage(@ModelAttribute ToClickHouseBo bo) {
        return this.testService.selectByByPage(bo);
    }
}
