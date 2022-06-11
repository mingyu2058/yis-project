package com.service.yis.controller;

import com.service.yis.domain.User.UserEntity;
import com.service.yis.domain.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("")
    public String index(Authentication authentication, Model model) {
        if(authentication==null)
            return "index";
        else{
            String userName = authentication.getName();
            model.addAttribute("name", userName);
            return "index";
        }

        /*
        String name = (String) userRepository.findByUserEmail("1234");
        model.addAttribute("name",name);
        return "index";*/
   /*     if (authentication.isAuthenticated()) {
            UserEntity userEntity = (UserEntity) authentication.getPrincipal();
            model.addAttribute("name", userEntity.getUserName());
            return "index";
        }
        else{
            return "index";
        }
*/
    }

	@GetMapping("/mypage")
   	 public String mypage(HttpServletRequest request, Model model) {
       
       HttpSession session = request.getSession();
       UserEntity userEntity = (UserEntity)session.getAttribute("UserEntity");
       
       model.addAttribute("user", userEntity);
       
       return "user/mypage";
    }
}
