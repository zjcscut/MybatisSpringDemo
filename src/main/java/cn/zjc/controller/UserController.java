package cn.zjc.controller;

import cn.zjc.entity.User;
import cn.zjc.service.UserService;
import cn.zjc.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjc.
 * 2016/1/21/14:59
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "find/{id}")
//    @ResponseBody
//    public String findUser(@PathVariable int id) {
//        User user = userService.selectByKey(id);
//        return JsonUtil.toJson(user);
//    }

    @RequestMapping(value = "find/page",method = RequestMethod.POST)
    @ResponseBody
    public String findByPage(@RequestParam(value = "phone",required = true)String phone){
        return JsonUtil.toJson(userService.findUserByPhone(phone));
    }

    @RequestMapping(value = "find/json",method = RequestMethod.POST)
    @ResponseBody
    public String testJson(@RequestParam(value = "phone",required = true)String phone){
        Map<String , Object> map = new HashMap<>();
        map.put("name","zjc");
        map.put("birth","11111");
        return JsonUtil.toJson(map);
    }
}
