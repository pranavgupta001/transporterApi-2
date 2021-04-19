package com.springboot.TransporterAPI.Controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.springboot.TransporterAPI.Entity.Transporter;
import com.springboot.TransporterAPI.Services.TransporterService;
import com.springboot.TransporterAPI.model.TransporterResponse;

@RestController
public class Controller extends ResponseEntityExceptionHandler {
	
	@Autowired
	private TransporterService service;
	
	@PostMapping("/transporter")
	public TransporterResponse addTransporter(@RequestBody Transporter transporter) {
		return service.addTransporter(transporter);
	}
	
	@GetMapping("/transporter")
	public List<Transporter> getApproved(@RequestParam boolean approved){
		return service.getApproved(approved);
	}
	
	@PutMapping("/transporter/{transporter_id}")
	public TransporterResponse updateTransporter(@PathVariable UUID transporter_id){
		return service.updateTransporter(transporter_id);
	}
	
	@DeleteMapping("/transporter/{transporter_id}")
	public TransporterResponse deleteTransporter(@PathVariable UUID transporter_id){
		return service.deleteTransporter(transporter_id);
	}

}
