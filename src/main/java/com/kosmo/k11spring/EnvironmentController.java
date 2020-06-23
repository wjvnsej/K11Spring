package com.kosmo.k11spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import env.BoardConnection;
import env.UserConnection;

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
	
	/*
	외부파일읽기2
		: XML설정파일에서 프로퍼티 파일을 명시한 후 직접 빈을
		생성하여 읽어오는 방법
	*/
	@RequestMapping("/environment/main2")
	public String main2(Model model) {
		
		//프로퍼티파일의 위치를 명시한 XML설정파일을 통해 스프링 컨테이너를 생성함.
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:EnvAppCtx.xml");
		
		UserConnection userCon = ctx.getBean("userConnection", UserConnection.class);
		
		model.addAttribute("mainUserId", userCon.getMainUserId());
		model.addAttribute("mainUserPw", userCon.getMainUserPw());
		model.addAttribute("subUserId", userCon.getSubUserId());
		model.addAttribute("subUserPw", userCon.getSubUserPw());
		
		return "05Environment/main2";
	}
	
	/*
	외부파일읽기3
		: 어노테이션을 이용한 외부파일 참조. XML 설정파일 대신
		EnvApplicationConfig클래스를 이용하여 외부파일을 읽어온다.
	*/
	@RequestMapping("/environment/main3")
	public String main3(Model model) {
		
		//어노테이션 기반 스프링 컨테이너 생성
		AnnotationConfigApplicationContext ctx = new 
				AnnotationConfigApplicationContext(EnvApplicationConfig.class);
		
		//설정파일에서 생성한 빈을 주입받음
		BoardConnection bConn = ctx.getBean("boardConfig", BoardConnection.class);
		
		model.addAttribute("id", bConn.getUser());
		model.addAttribute("pass", bConn.getPass());
		model.addAttribute("driver", bConn.getDriver());
		model.addAttribute("url", bConn.getUrl());
		
		return "05Environment/main3";
	}

}















