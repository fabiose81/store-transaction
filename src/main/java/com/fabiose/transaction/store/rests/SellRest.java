package com.fabiose.transaction.store.rests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabiose.transaction.store.domains.Sell;
import com.fabiose.transaction.store.services.SellService;

@RestController
@RequestMapping("/sell")
public class SellRest {
	
	@Autowired
	private SellService sellService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody Sell sell){
		try {
			sellService.save(sell);
			return ResponseEntity.status(HttpStatus.OK).body("ok");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
