package com.charvikent.onlineorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.charvikent.onlineorder.dao.ChocolateDao;
import com.charvikent.onlineorder.model.Chocolate;

public class ChocolateController {
	@Autowired
	ChocolateDao chocolateDao;
	
	
	
	@RequestMapping(value = "/chocolate", method = RequestMethod.GET, headers = "Accept=application/json")
	public String showChocolatePage(Model model)
	{
		
		
		model.addAttribute("empbean" ,new Chocolate());
		
		
		
		List<Chocolate> list=chocolateDao.getAllChocolates();
		model.addAttribute("list",list);
		
		System.out.println(list);
		return "chocolate";
		
		
		
		
	}
}
