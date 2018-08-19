package com.example.template.controller;

import com.example.template.entity.User;
import com.example.template.response.Response;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/template")
@Api(value = "MainController", description = "主操作入口")
public class MainController {
    @GetMapping("/hello")
    @ApiOperation(value="测试接口", notes="测试网络联通")
    public Response hellWorld() {
        Response response = new Response();
        response.success("heollo world!");
        return response;
    }

    @GetMapping("/int/{intger}")
    public Response printIntegr(@PathVariable Integer intger) {
        return new Response().success("integer is " + intger);
    }

    @PostMapping("/user")
    @ApiOperation(value="新增用户", notes="新增用户接口")
//    @ApiImplicitParams()
    public boolean addUser(@RequestBody User user) {

        return true;
    }
}
