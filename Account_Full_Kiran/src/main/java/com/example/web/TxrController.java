package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Txn;
import com.example.repository.AccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TxrService;

@Controller
public class TxrController {

	@Autowired
	private TxrService txrService;

	@RequestMapping(value = "/txr.htm", method = RequestMethod.GET)
	public String showTxrForm() {
		// ..
		return "txr-form";
	}

	@RequestMapping(value = "/txr.htm", method = RequestMethod.POST)
	public String doTxr(@ModelAttribute TxrRequest request,Model model) {
		boolean b = txrService.transfer(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
		TxrResponse response = new TxrResponse();
		response.setMessage(b ? "Txr Successful" : "Txr Failed");
		model.addAttribute("status", response);
		return "txr-status";
	}
	
	@RequestMapping(value = "/statement.htm", method = RequestMethod.GET)
	public String listTxns(Model model){    

	    List<Txn> list = txrService.retrieve("Txn");
	    model.addAttribute("lists",list);

	    return "state-status";
	}
}