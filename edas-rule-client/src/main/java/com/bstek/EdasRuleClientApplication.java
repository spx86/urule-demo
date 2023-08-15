package com.bstek;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
//import com.bstek.urule.runtime.response.ExecutionResponseImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class EdasRuleClientApplication {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = SpringApplication.run(EdasRuleClientApplication.class, args);
		
		//创建一个KnowledgeSession对象
        KnowledgeService knowledgeService = (KnowledgeService) ctx.getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("test/202308080002");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        Map<String, Object> param = new HashMap<>();
        param.put("age", 22);
        String result = new String();
        session.insert(result);
        session.fireRules(param);

       // Integer result = (Integer) session.getParameter("age");
        System.out.println("年龄：" + session.getParameter("age"));
        System.out.println("结果：" + session.getParameter("result"));
	}
}
