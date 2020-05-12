package com.store.store.controller;

import com.store.store.Service.RequireService;
import com.store.store.Service.UserService;
import com.store.store.VO.AdminGetRequire;
import com.store.store.VO.RequireUser;
import com.store.store.entity.Require;
import com.store.store.entity.User;
import com.store.store.entity.WareHouse;
import com.store.store.entity.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/require")
public class RequireController {
    @Autowired
    RequireService requireService;
    @Autowired
    UserService userService;
    @PostMapping("/addRequire")
    public Integer addRequire(@RequestBody Require require){
        System.out.println(require);
        return requireService.addRequire(require);
    }
    @PostMapping("/adminGetRequire")
    public List<AdminGetRequire> adminGetRequire(){
        List<Require>requires=requireService.adminGetRequire();
        List<AdminGetRequire> adminGetRequires = new ArrayList<>();
        for (Require r:
             requires) {
            AdminGetRequire adminGetRequire = new AdminGetRequire();
            User u = new User();
            u.setUserId(r.getUserId());
            User tu = userService.findUserById(u);
            adminGetRequire.setUserName(tu.getUserName());//用户名
            adminGetRequire.setCreateTime(r.getCreateTime());
            adminGetRequire.setItemInf(r.getItemInf());
            adminGetRequire.setStatus(r.getStatus());
            adminGetRequire.setUserId(Integer.valueOf(r.getUserId()));
            adminGetRequire.setRequireId(r.getRequireId());
            List<Window> windows = requireService.findWindowByUserId(u);
            adminGetRequire.setWindowNum(windows.get(0).getWindowNum());
            List<WareHouse> wareHouses=requireService.findWareHouseByWareHouseId(windows.get(0));
            adminGetRequire.setName(wareHouses.get(0).getName());
            adminGetRequires.add(adminGetRequire);
        }
        return adminGetRequires;
    }
    @PostMapping("/updateRequire")
    public Integer updateRequire(@RequestBody Require require){
        return requireService.updateRequire(require);
    }
    @PostMapping("/getUnOutputRequire")
    public List<Require> getUnOutputRequire(@RequestBody RequireUser requireUser){
        return requireService.getUnOutputRequire(requireUser);
    }
    @PostMapping("/getUnOutputResolve")
    public List<Require> getUnOutputResolve(@RequestBody RequireUser requireUser){
        return requireService.getUnOutputResolve(requireUser);
    }
    @PostMapping("/updateItemInf")
    public Integer updateItemInf(@RequestBody Require require){
        return requireService.updateItemInf(require);
    }
}
