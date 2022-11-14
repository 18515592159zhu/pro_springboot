package com.itheima.service.impl;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 9:11
 * @Version 1.0
 * 发送网页正文邮件
 */
//@Service
public class SendMailServiceImpl2 implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;


    //发送人
    private String from = "test@qq.com";
    //接收人
    private String to = "test@123.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "<a href='https://www.baidu.com/'>点开有惊喜</a>";

    @Override
    public void sendMail() {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(to + "(小甜甜)");
            helper.setTo(from);
            helper.setSubject(subject);
            helper.setText(context, true);//此处设置正文支持html解析

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}