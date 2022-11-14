package com.itheima.service.impl;

import com.itheima.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Author zhuchifeng
 * @Date 2022/10/26 9:11
 * @Version 1.0
 */
@Service
public class SendMailServiceImpl3 implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;


    //发送人
    private String from = "test@qq.com";
    //接收人
    private String to = "test@163.com";
    //标题
    private String subject = "测试邮件";
    //正文
    private String context = "测试邮件正文";

    @Override
    public void sendMail() {

        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);//此处设置支持附件
            helper.setFrom(to + "(小甜甜)");
            helper.setTo(from);
            helper.setSubject(subject);
            helper.setText(context, true);

            //添加附件
            File f1 = new File("D:\\IdeaProjects\\pro_springboot\\springboot_23_mail\\src\\main\\resources\\springboot_23_mail-0.0.1-SNAPSHOT.jar");
            File f2 = new File("D:\\IdeaProjects\\pro_springboot\\springboot_23_mail\\src\\main\\resources\\logo.png");

            helper.addAttachment(f1.getName(), f1);
            helper.addAttachment("最靠谱的培训结构.png", f2);

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}