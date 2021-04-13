package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.LocationStats;
import com.example.demo.services.CoronaVirusDataService;

@RestController
public class HomeController {
	
	@Autowired
	CoronaVirusDataService service;
	
	@GetMapping("/situation")
	public List<LocationStats> getSituation (Model model) {
		List<LocationStats> allStats = service.getAllStats();
//		int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
//		int totalChanges = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
//		model.addAttribute("locationStats", service.getAllStats());
//		model.addAttribute("totalCases", totalCases);
//		model.addAttribute("totalChanges", totalChanges);
//		return "home";
		return allStats;
	}
}
