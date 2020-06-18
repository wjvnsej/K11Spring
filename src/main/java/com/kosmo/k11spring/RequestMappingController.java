package com.kosmo.k11spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestMappingController {
	
	@RequestMapping("/requestMapping/index.do")
	public String rmIndex() {
		
		return "02RequestMapping/index";
	}
}
