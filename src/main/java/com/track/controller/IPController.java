package com.track.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.track.service.IPService;

@RestController
@CrossOrigin
public class IPController {
	
	@Autowired
	private IPService _service ;

	@GetMapping(path = "/info" , produces = MediaType.APPLICATION_JSON_VALUE)
	public String getDetails(@RequestParam("ip") String ip) {
		  return this._service.getInfo(ip);
	}
	
}