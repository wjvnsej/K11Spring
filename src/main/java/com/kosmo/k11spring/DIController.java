package com.kosmo.k11spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import di.CalculatorDTO;

@Controller
public class DIController {
	
	@RequestMapping("/di/myCalculator")
	public String myCal(Model model) {
		
		String configLocation = "classpath:DIAppCtxCalculator.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		
		CalculatorDTO myCal = ctx.getBean("myCal", CalculatorDTO.class);
		
		model.addAttribute("addResult", myCal.add());
		model.addAttribute("subResult", myCal.sub());
		model.addAttribute("mulResult", myCal.mul());
		model.addAttribute("divResult", myCal.div());
		
		return "04DI/myCalculator";
	}
	
}
