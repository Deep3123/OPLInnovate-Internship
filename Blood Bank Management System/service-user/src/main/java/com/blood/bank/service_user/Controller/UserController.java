package com.blood.bank.service_user.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blood.bank.service_user.Proxy.BloodGroupAvailbilityStatusProxy;
import com.blood.bank.service_user.Proxy.PatientBloodUtilizationHistoryProxy;
import com.blood.bank.service_user.Proxy.UserProxy;
import com.blood.bank.service_user.Service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

//	public String serachBloodGroupDetails(String bloodGroup);

//	public String orderBloodInUnit(String bloodGroupid);

	@Autowired
	private UserService userService;

//	public String deleteUserByUsername(String username);
	@GetMapping("/deleteUser/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "username") String username) {
		return new ResponseEntity<String>(userService.deleteUserByUsername(username), HttpStatus.OK);
	}

//	public List<UserProxy> getAllUser();
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserProxy>> getAllUser() {
		return new ResponseEntity<List<UserProxy>>(userService.getAllUser(), HttpStatus.OK);
	}

//	public UserProxy getUserByUsername(String username);
	@GetMapping("/getUser/{username}")
	public ResponseEntity<UserProxy> getUser(@PathVariable(value = "username") String username) {
		return new ResponseEntity<UserProxy>(userService.getUserByUsername(username), HttpStatus.OK);
	}

//	public UserProxy saveUser(UserProxy userproxy);
	@GetMapping("/saveUser")
	public ResponseEntity<UserProxy> saveUser(@RequestBody UserProxy userproxy) {
		return new ResponseEntity<UserProxy>(userService.saveUser(userproxy), HttpStatus.CREATED);
	}

//	public String serachBloodGroupDetails(String bloodGroup);

//	@GetMapping("/serach-BloodGroup-Details/{bloodGroup}")
//	public ResponseEntity<String> serachBloodGroupDetails(@PathVariable String bloodGroup) {
//		return null;
//	}
//
////	public String orderBloodInUnit(String bloodGroupid);
//	@GetMapping("/order-BloodInUnit/{bloodGroupid}")
//	public ResponseEntity<String> orderBloodInUnit(@PathVariable String bloodGroupid) {
//		return null;
//	}

	@GetMapping("/getBloodGroupDetails/{bloodGroupName}")
	public ResponseEntity<BloodGroupAvailbilityStatusProxy> getBloodGroupDetails(@PathVariable String bloodGroupName) {
		return new ResponseEntity<>(userService.getBloodGroupDetails(bloodGroupName), HttpStatus.OK);
	}

	@PostMapping("/saveOrderDetails")
	public ResponseEntity<String> saveOrderDetails(
			@RequestBody PatientBloodUtilizationHistoryProxy bloodUtilizationHistoryProxy) {
		return new ResponseEntity<>(userService.saveOrderDetails(bloodUtilizationHistoryProxy), HttpStatus.CREATED);
	}

}
