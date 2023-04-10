package com.restorant.Restorant.Controller;

import com.restorant.Restorant.Full.userFull.UsersFull;
import com.restorant.Restorant.Service.UserService;
import com.restorant.Restorant.pyload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class UserController implements UsersFull {
    @Autowired
    UserService userService;

    @Override
    @PostMapping
    @ResponseBody
    public Result register(ReqUser reqUser) {
        return userService.addUser(reqUser);
    }

    @Override
    @GetMapping
    public String getUser() {
        return "UsersPanel";
    }

    @Override
    @GetMapping("/list")
    @ResponseBody
    public List<ResUser> getUsersList() {
        return userService.getUsersList();
    }

    @GetMapping ("/contact")
    public String contact(){
        return "Contact";
    }

    @PostMapping("/zakaz/{id}")
    @ResponseBody
    public Result buyProduct(@PathVariable Integer id, @RequestBody ReqBuy reqBuy){
        return userService.buyProduct(id,reqBuy);
    }

    @GetMapping("/zakazlar")
    public String Zakazlar(){
        return "Zakaz";
    }

    @GetMapping("000:97:92/shahrizod/zakaz")
    @ResponseBody
    public List<ResBuy> getZakaz(){
        return userService.getZakaz();
    }
}
