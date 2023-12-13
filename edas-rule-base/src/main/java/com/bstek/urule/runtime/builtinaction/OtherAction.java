package com.bstek.urule.runtime.builtinaction;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.resource.ClassPathResource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;
import toolgood.words.StringSearch;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bstek.urule.model.library.action.annotation.ActionBean;
import com.bstek.urule.model.library.action.annotation.ActionMethod;
import com.bstek.urule.model.library.action.annotation.ActionMethodParameter;

/**
 * @author Spengxu
 * @since 2023年10月14日
 */
@ActionBean(name="其他")
@Component
@ConditionalOnClass(StringSearch.class)
public class OtherAction{

    private static StringSearch search;
    String sensitiveWordFileName="sensitive_word.txt";

    @PostConstruct
    private void init(){
//
        ClassPathResource classPathResource = new ClassPathResource(sensitiveWordFileName);
        InputStream inputStream = classPathResource.getStream();
        List<String> words = this.readLines(inputStream);
        search = new StringSearch();
        search.SetKeywords(words);
    }

    private List<String> readLines(InputStream inputStream){
        InputStreamReader isr = new InputStreamReader(inputStream);//传入InputStream in　键盘录入对象 in
        List<String> words=new ArrayList<>();
        //为了提高效率,将字符串进行缓冲区技术高效操作.使用BufferedReader
        BufferedReader bufr = new BufferedReader(isr);
        String line = null;
        try {
            while ((line = bufr.readLine())!=null) {
                words.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bufr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return words;

    }

    public static String filter(String str){
        return search.Replace(str,'*');
    }

    @ActionMethod(name="敏感词检测")
	@ActionMethodParameter(names={"目标字符串"})
	public String sensitive(String str){
		if(str==null){
			return str;
		}
        if(search.ContainsAny(str)){
            return "疑似存在违规内容";
        }
		//return search.Replace(str,'*');
        return "";
	}
    
}