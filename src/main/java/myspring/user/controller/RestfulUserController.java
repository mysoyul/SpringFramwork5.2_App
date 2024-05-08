package myspring.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.xml.UserVOXML;

@RestController
@RequestMapping("/users")
public class RestfulUserController {
	private UserService userService;

	//Constructor Injection
	public RestfulUserController(UserService userService) {
		System.out.println(this.getClass().getName() + " 생성자 호출됨!");
		this.userService = userService;
	}

	//@RequestMapping(value="/users", method=RequestMethod.GET, produces = { "application/json"})
	@GetMapping
	public List<UserVO> getUserList() {
		List<UserVO> userList = userService.getUserList();
		return userList;
	}
	
	//@RequestMapping(value="/users/{id}", method=RequestMethod.GET,produces = { "application/json"})
	@GetMapping("/{id}")
	public UserVO getUser(@PathVariable("id") String userid) {
		UserVO user = userService.getUser(userid);
		return user;
	}
		
	//@RequestMapping(value="/users",method=RequestMethod.POST, headers = {"Content-type=application/json"})
	@PostMapping
	public Boolean insertUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
	//@RequestMapping(value="/users",method=RequestMethod.PUT,headers = {"Content-type=application/json"})
	@PatchMapping("/{userid}")
	public Boolean updateUser(@PathVariable String userid, @RequestBody UserVO userDetail) {
		UserVO user = userService.getUser(userid);
		if (user != null) {
			user.setCity(userDetail.getCity());
			userService.updateUser(user);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
	//@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/{userid}")
	public Boolean deleteUser(@PathVariable String userid) {
		UserVO user = userService.getUser(userid);
		if (user != null) {
			userService.deleteUser(userid);
			return Boolean.TRUE;
		} else {		
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value="/xml", method=RequestMethod.GET, produces = { "application/xml"})
	public UserVOXML getUserListXml() {
		List<UserVO> list = userService.getUserList();
		UserVOXML xml = new UserVOXML("success", list);
		return xml;
	}	
}
