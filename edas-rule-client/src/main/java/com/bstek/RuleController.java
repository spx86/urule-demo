package com.bstek;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.*;
import java.util.List;
import java.util.List.*;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.response.RuleExecutionResponse;
import com.bstek.urule.runtime.service.KnowledgeService;

@RestController
<<<<<<< HEAD
//@CrossOrigin(origins = {"http://106.52.244.132:8888")
@CrossOrigin(origins = {"*"})
=======
@CrossOrigin(origins = "http://106.52.244.132:8888")
>>>>>>> 40ee03a26840f4c0c80b9bffe6478fab52413687
@RequestMapping("rule")

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
        }

        String result = new String();
        session.insert(result);
        RuleExecutionResponse result1 = session.fireRules(params);
        //System.out.println("年龄：" + session.getParameter("age"));
        System.out.println("结果：" + session.getParameter("result"));
        return result1;
    }
   
    @RequestMapping(value="/ruleEngine", consumes="application/json")
    public ResponseEntity<String> ruleJson(@RequestBody Map<String, Object> queryParams) throws IOException {
    	//创建一个KnowledgeSession对象
        Map<String, Object> params = new HashMap<>();
        List<Map<String, Object>> jsonDataList = new ArrayList<>();

        String packageid = (String) queryParams.get("packageid");
        List<Map<String, Object>> data = (List<Map<String, Object>>) queryParams.get("data");

        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge(packageid);
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

        for (Map<String, Object> item : data) {
            Map<String, Object> jsonData = new HashMap<>();
            String result = new String();
            // 遍历每个 Map 数据项
            for (Map.Entry<String, Object> entry : item.entrySet()) {
                 params.put(entry.getKey(), entry.getValue());
                 jsonData.put(entry.getKey(), entry.getValue());
            }
            session.insert(result);
            RuleExecutionResponse result1 =session.fireRules(params);
            //session.startProcess("flow-test",params);
            jsonData.put("result", session.getParameter("result"));
            jsonDataList.add(jsonData);
            //System.out.println("结果：" + session.getParameter("result"));
        }
        ObjectMapper objectMapper = new ObjectMapper();

        // 将Map转换为JSON字符串
        String json = objectMapper.writeValueAsString(jsonDataList);

        
        return ResponseEntity.ok(json);
    }
}