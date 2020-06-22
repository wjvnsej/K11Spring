package com.kosmo.k11spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import common.MemberDTO;
import common.MemberValidator;

@Controller
public class validateController {
	
	@RequestMapping("/validate/memberRegist.do")
	public String memberRegist() {
		
		return "03Validate/memberRegist";
	}
	
	//회원가입페이지의 폼값을 전송받아 검증하는 메소드
	@RequestMapping("/validate/registProc")
	public String registProc(
			@ModelAttribute("mInfo") MemberDTO memberDTO,
			BindingResult result, Model model) {
		
		String viewPage = "03Validate/memberDone";
		
		MemberValidator validator = new MemberValidator();
		validator.validate(memberDTO, result);
		
		if(result.hasErrors()) {
			System.out.println("유효성 체크 실패 : " + result.toString());
			model.addAttribute("formError", "폼값 유효성체크에 실패하였습니다.");
			viewPage = "03Validate/memberRegist";
		}
		return viewPage;
	}
}
