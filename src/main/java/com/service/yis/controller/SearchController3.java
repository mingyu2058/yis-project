package com.service.yis.controller;

import com.service.yis.product.ProductDAO;
import com.service.yis.product.ProductVO;
import com.service.yis.product.PageMakeDTO;
import com.service.yis.product.Criteria;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;


@Controller
@RequestMapping(value = "/detailSearch", method = RequestMethod.GET)
public class SearchController3 {
    String keyword = "";
    ProductVO productVO = new ProductVO();
    ProductDAO dao = new ProductDAO();
    List productList = null;

    @GetMapping
    public String doC(HttpServletRequest request, Model model, Criteria cri) throws ParseException {
        keyword = request.getParameter("categoryB");
        String categoryA = request.getParameter("categoryA");
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
        String priceS = request.getParameter("price");

        int priceF = Integer.parseInt(priceS);
        productVO.setProduct_name(keyword);
        productVO.setDate1(date1);
        productVO.setDate2(date2);
        productVO.setPrice(priceF);
        productList = dao.listDetail(productVO, cri);
        int total = dao.getDetailTotal(productVO);

        PageMakeDTO paging = new PageMakeDTO();
        paging.setCri(cri);
        paging.setTotal(total);

        model.addAttribute("detailList", productList);
        model.addAttribute("pagingD", paging);
        model.addAttribute("categoryA", categoryA);
        model.addAttribute("categoryB", keyword);
        model.addAttribute("date1", date1);
        model.addAttribute("date2", date2);
        model.addAttribute("price", priceS);

        return "search/testDetailRes";
    }
}

