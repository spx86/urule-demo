package com.bstek;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.response.RuleExecutionResponse;
import com.bstek.urule.runtime.service.KnowledgeService;

@RestController
@RequestMapping("rule")
// public class RuleController {
	
// 	@RequestMapping("/ageRule")
//     public RuleExecutionResponse rule(@RequestParam String age) throws IOException {
//     	//创建一个KnowledgeSession对象
//         Map<String, Object> param = new HashMap<>();
//        // param.put("packageId", packageId);
//         KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
//         KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("test/202308080002");
//         KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

//        // Map<String, Object> param = new HashMap<>();
//         param.put("age", age);
//         String result = new String();
//         session.insert(result);
//         RuleExecutionResponse result1 = session.fireRules(param);
//         System.out.println("年龄：" + session.getParameter("age"));
//         System.out.println("结果：" + session.getParameter("result"));
//         return result1;
//     }
// }





public class RuleController {
	
	@RequestMapping("/ageRule")
    public RuleExecutionResponse rule(@RequestParam String packageid, @RequestParam Map<String, Object> queryParams) throws IOException {
    	//创建一个KnowledgeSession对象
        Map<String, Object> params = new HashMap<>();
        //param.put("packageId", packageid);
        
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge(packageid);
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        for (Entry<String, Object> entry : queryParams.entrySet()){
            params.put(entry.getKey(), entry.getValue());
            // String param = param.getKey();
            // String value = param.getValue();
            // // 在这里根据参数名和值进行处理
            // System.out.println("Parameter " + param + " has value " + value);
        }
       // Map<String, Object> param = new HashMap<>();
        //param.put("age", age);
        String result = new String();
        session.insert(result);
        RuleExecutionResponse result1 = session.fireRules(params);
        //System.out.println("年龄：" + session.getParameter("age"));
        System.out.println("结果：" + session.getParameter("result"));
        return result1;
    }
}