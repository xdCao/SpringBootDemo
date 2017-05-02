package EnterpriseTransactionManagement.controller;

import EnterpriseTransactionManagement.dao.MessageRepository;
import EnterpriseTransactionManagement.domain.Employ;
import EnterpriseTransactionManagement.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by xdcao on 2017/5/2.
 */
@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(value = "/goWrite")
    public String goWrite(){
        return "write";
    }


    @RequestMapping(value = "write",method = RequestMethod.POST)
    public ModelAndView write(@RequestParam String title, @RequestParam String content, HttpSession httpSession){

        Message message=new Message();
        message.setMessageTitle(title);
        message.setMessageContent(content);
        message.setPublishTime(new Date());
        message.setEmployByEmployId((Employ) httpSession.getAttribute("current"));

        messageRepository.save(message);

        return new ModelAndView("info","employ",(Employ) httpSession.getAttribute("current"));

    }


    @RequestMapping("/read")
    public ModelAndView readAll(){

        List<Message> messages=messageRepository.findAll();

        return new ModelAndView("read","messages",messages);

    }

    @RequestMapping(value = "/detail")
    public ModelAndView readOne(@RequestParam int id){

        Message message=messageRepository.findOne(id);

        return new ModelAndView("detail","message",message);

    }


}
