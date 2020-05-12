package com.store.store.controller;

import com.store.store.Service.OutputService;
import com.store.store.entity.Goods;
import com.store.store.entity.Require;
import com.store.store.entity.User;
import com.store.store.entity.Window;
import com.store.store.mapper.OutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;
    @PostMapping("/getWindow")
    public List<Window> getWindow(@RequestBody User user){
        return outputService.getWindow(user);
    }
    @PostMapping("/getRequireIs2ByUserId")
    public List<Require> getRequireIs2ByUserId(@RequestBody Window window){
        System.out.println(window);
        return outputService.getRequireIs2ByUserId(window);
    }
    @PostMapping("/output")
    public Integer output(@RequestBody Require require){

        return outputService.output(require);
    }
    @PostMapping("/endOutput")
    public  Integer endOutput(@RequestBody Require require){
        return outputService.endOutput(require);
    }
    @PostMapping("/updateGoods")
    public Integer updateGoods(@RequestBody  Goods goods){
        return outputService.updateGoods(goods);
    }
}
