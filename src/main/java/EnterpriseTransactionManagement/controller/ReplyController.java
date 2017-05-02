package EnterpriseTransactionManagement.controller;

import EnterpriseTransactionManagement.dao.MessageRepository;
import EnterpriseTransactionManagement.dao.ReplyRepository;
import EnterpriseTransactionManagement.domain.Employ;
import EnterpriseTransactionManagement.domain.Message;
import EnterpriseTransactionManagement.domain.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by xdcao on 2017/5/2.
 */
@Controller
public class ReplyController {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private MessageRepository messageRepository;


    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    public ModelAndView addReply(@RequestParam int id, @RequestParam String content, HttpSession session){

        Reply reply=new Reply();
        reply.setReplyTime(new Date());
        reply.setEmployByEmployId((Employ) session.getAttribute("current"));
        reply.setReplyContent(content);
        Message message=messageRepository.findOne(id);
        reply.setMessageByMessageId(message);

        replyRepository.save(reply);

        return new ModelAndView("detail","message",message);

    }

}
