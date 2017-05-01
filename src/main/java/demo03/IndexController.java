package demo03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by xdcao on 2017/5/1.
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @Value(value = "${caohao.secret}")
    private String secret;

    @Value(value = "${caohao.number}")
    private int id;

    @Value(value = "${caohao.desc}")
    private String desc;

    @RequestMapping
    public String index(){
        return "hello world";
    }

    @RequestMapping(value = "/get")
    public HashMap<String,Object> get(@RequestParam String name){
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("title","hello world");
        map.put("name",name);
        map.put("secret",secret);
        map.put("id",id);
        map.put("desc",desc);
        return map;
    }

    @RequestMapping(value = "/get/{id}/{name}")
    public User getUser(@PathVariable int id, @PathVariable String name){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        return user;
    }

}
