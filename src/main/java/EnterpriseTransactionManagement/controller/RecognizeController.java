package EnterpriseTransactionManagement.controller;

import EnterpriseTransactionManagement.dao.UserRepository;
import EnterpriseTransactionManagement.domain.Employ;
import EnterpriseTransactionManagement.domain.MyError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebMvcProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpSession;

/**
 * Created by xdcao on 2017/5/1.
 */
@Controller
public class RecognizeController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(){
        return "recognize";
    }


    @RequestMapping(value = "/recognize",method = RequestMethod.POST)
    public ModelAndView recoginze(@RequestParam String name, @RequestParam String password, HttpSession httpSession){

        Employ employ=userRepository.findByEmployNameAndPassword(name,password);

//        Employ employ=userRepository.getOne(1);
        System.out.println(name+", "+password);

        if (employ!=null){
            httpSession.setAttribute("current",employ);
            return new ModelAndView("info","employ",employ);
        }else {
            MyError error=new MyError();
            error.setInfo("用户名或密码错误");
            return new ModelAndView("myerror","error",error);
        }


    }

}
