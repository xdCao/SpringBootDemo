package EnterpriseTransactionManagement.controller;

import EnterpriseTransactionManagement.dao.UserRepository;
import EnterpriseTransactionManagement.domain.Employ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xdcao on 2017/5/1.
 */
@RestController
public class RecognizeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/recognize",method = RequestMethod.POST)
    public String recoginze(@RequestParam String name,@RequestParam String password){

        Employ employ=userRepository.findByEmployNameAndPassword("caohao",password);

//        Employ employ=userRepository.getOne(1);
        System.out.println(name+", "+password);
        if (employ==null){
            return "该用户不存在";
        }else {
            return employ.getEmployPhone();
        }

    }

}
