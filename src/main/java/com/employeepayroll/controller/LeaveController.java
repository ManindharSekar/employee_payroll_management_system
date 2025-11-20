package com.employeepayroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.entity.Leave;
import com.employeepayroll.service.LeaveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("leave")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	@PostMapping("/addLeave")
	public ResponseEntity<String> addLeave(@RequestBody Leave leave) {
		return leaveService.addLeave(leave);

	}
	
	@GetMapping("/getLeave/{id}")
	public Leave getLeave(@PathVariable Long id) {
		return leaveService.getLeave(id);
	}
	

}
