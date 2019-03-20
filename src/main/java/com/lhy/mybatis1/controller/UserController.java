package com.lhy.mybatis1.controller;


import com.lhy.mybatis1.service.UserService;
import com.lhy.mybatis1.vo.ApiResult;
import com.lhy.mybatis1.vo.ApiResultGenerator;
import com.lhy.mybatis1.vo.CreateWaybill;
import com.lhy.mybatis1.vo.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult login(@RequestBody @Valid LoginInfo loginInfo){
        return userService.login(loginInfo);
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.POST)
    public ApiResult selectAll(){
        return userService.selectAll();
    }

    //开单
    @RequestMapping(value = "/createWaybill", method = RequestMethod.POST)
    public ApiResult createWaybill(@RequestBody CreateWaybill waybillInfo){
        log.info(waybillInfo.toString());
        return ApiResultGenerator.successResult("");
    }


















    //    private StringRedisTemplate stringRedisTemplate;
    //    @Autowired

    //    public String hello() {
    //        return "test.html";
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    }
//
//
//    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
//    public ApiResult findAll() {
//        return ApiResultGenerator.successResult(userService.selectAll());
//    }
//
////    @RequestMapping(value = "/add", method = RequestMethod.POST)
////    public ApiResult add(@RequestBody @Valid User user) {
////        int data = userService.insert(user);
////        log.info("插入后" + user.toString());
////        return ApiResultGenerator.successResult(data);
////    }
////
////    @RequestMapping(value = "/delete", method = RequestMethod.POST)
////    public ApiResult delete(@RequestBody User user) {
////        return ApiResultGenerator.successResult(userService.deleteByPrimaryKey(user));
////    }
////
////    @RequestMapping(value = "/update", method = RequestMethod.POST)
////    public ApiResult update(@RequestBody User user) {
////        return ApiResultGenerator.successResult(userService.updateByPrimaryKey(user));
////    }
//
//    //    @Cacheable(value = "order")
//    @RequestMapping(value = "/findOrder", method = RequestMethod.POST)
//    public ApiResult findOrderByUserId(@RequestBody User user) {
//        OrderDetail orderDetail = userService.findOrderByUserId(user.getId());
//        return ApiResultGenerator.successResult(orderDetail);
//    }
//
//    @RequestMapping(value = "/setValue", method = RequestMethod.GET)
//    public ApiResult setValue(@RequestParam String name) {
//        if (stringRedisTemplate.hasKey("name")) {
//            return ApiResultGenerator.errorResult("姓名已存在");
//        } else {
//            stringRedisTemplate.opsForValue().append("name", name);
//        }
//        return ApiResultGenerator.successResult(stringRedisTemplate.opsForValue().get("name"));
//    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ApiResult upload(@RequestParam String waybillid , MultipartFile[] parts) throws Exception {
        log.info("运单号："+waybillid);
        for (MultipartFile multipartFile : parts) {
            if (!multipartFile.isEmpty()) {
                System.out.println("文件名："+multipartFile.getOriginalFilename());
                System.out.println("大小:"+multipartFile.getSize());
//                BufferedOutputStream out = new BufferedOutputStream(
//                        new FileOutputStream(new File("E:/IdeaProjects/mybatis1/src/main/resources/upload",
//                                multipartFile.getOriginalFilename())));
            }
        }

        return ApiResultGenerator.successResult("success");
    }
//
//    @RequestMapping(value = "/getTabs", method = RequestMethod.GET)
//    public ApiResult getTabs() {
//        List<Tab> tabs = new ArrayList<>();
//        Tab tab1 = new Tab("装车扫描", "", false);
//        Tab tab2 = new Tab("拍照制单", "", false);
//        Tab tab3 = new Tab("百度", "https://www.baidu.com", true);
//        Tab tab4 = new Tab("腾讯", "https://www.qq.com", true);
//        Tab tab5 = new Tab("淘宝", "https://www.taobao.com", true);
//        Tab tab6 = new Tab("github", "https://www.github.com", true);
//        tabs.add(tab1);
//        tabs.add(tab2);
//        tabs.add(tab3);
//        if (new Random().nextBoolean()) {
//            tabs.add(tab4);
//            tabs.add(tab5);
//            tabs.add(tab6);
//        }
//        log.info("tabs:"+tabs);
//        return ApiResultGenerator.successResult(tabs);
//    }
//

}
