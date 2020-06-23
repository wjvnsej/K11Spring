package com.kosmo.k11spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnvironmentController {
	
	/*
	외부파일참조1
		: Environment 객체를 사용하여 properties 파일의 내용을 읽어온다.
	*/
	@RequestMapping("/environment/main1")
	public String main1(Model model) {
		
      
		/*
		1. 스프링 컨택스트 생성
		 */
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		
		//2. Environment 객체를 생성
		ConfigurableEnvironment env =  ctx.getEnvironment();
		
		//3. getPropertySources를 가져와서 외부파일을 읽을 준비를 함.
		MutablePropertySources propertySources = env.getPropertySources();
      
		String adminIdStr = "";
		String adminPwStr = "";
		  
		try {
			/*
			외부파일의 경로를 지정한 후 addLast()메소드를 통해 
			프로퍼티소스를 추가한다.
			*/
			String envPath = "classpath:EnvAdmin.properties";
			propertySources.addLast(
					new ResourcePropertySource(envPath));
			
			//5. 파일의 내용을 읽어 변수에 저장함.
			adminIdStr = env.getProperty("admin.id");
			adminPwStr = env.getProperty("admin.pw");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//위에서 저장된 내용을 model객체에 저장한 후 View로 전달
		model.addAttribute("adminID", adminIdStr);
		model.addAttribute("adminPW", adminPwStr);
		
		return "05Environment/main1";
	}
	
	@RequestMapping("/environment/main2")
	public String main2(Model model) {
		
		return "05Environment/main2";
	}
	
	@RequestMapping("/environment/main3")
	public String main3(Model model) {
		
		return "05Environment/main3";
	}

}