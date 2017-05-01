package demo01;

import org.omg.CORBA.OBJECT_NOT_EXIST;
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

    @RequestMapping
    public String index(){
        return "Hello world";
    }

    @RequestMapping(value = "/get")
    public HashMap<String,Object> get(@RequestParam String name){
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("title","hello world");
        map.put("name",name);
        return map;
    }

    @RequestMapping(value = "/get/{id}/{name}")
    public User getUser(@PathVariable int id,@PathVariable String name){
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setDate(new Date());
        return user;
    }

}
