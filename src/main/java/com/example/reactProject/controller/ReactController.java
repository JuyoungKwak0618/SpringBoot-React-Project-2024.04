package com.example.reactProject.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.reactProject.entity.User;
import com.example.reactProject.service.UserService;
import com.nimbusds.jose.shaded.gson.JsonArray;

import lombok.RequiredArgsConstructor;

@RestController			// rendering 하지 않고, 데이터를 보내는 컨트롤러 (ResponseBody 느낌)
@RequestMapping("/react")
@RequiredArgsConstructor
public class ReactController {
	private final UserService uSvc;
	
	@GetMapping("/data")
	public String data() {
		return "스프링부트에서 보낸 데이터";
	}
	
	@GetMapping("/json")
	public String json() {
		JSONObject jObj = new JSONObject();
		jObj.put("uid", "james");
		jObj.put("uname", "제임스");
		return jObj.toString();
	}
	
	@PostMapping("/form")
	public String form(String uid, String uname) {
		System.out.println("uid=" + uid + ", uname=" + uname);
		return "uid=" + uid + ", uname=" + uname;
	}
	
	@PostMapping("/multi")
	public String form(String uid, String uname, MultipartFile file) {
		String msg = "uid=" + uid + ", uname=" + uname + ", fname=" + file.getOriginalFilename();
		System.out.println(msg);
		return msg;
	}
	
	@GetMapping("/user")
	public JSONArray userList() {
		JSONArray jsonArray = new JSONArray();
		 List<User> list = uSvc.getUserList();
		for (User user : list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("uid", user.getUid());
            jsonObject.put("name", user.getUname());
            jsonObject.put("regdate", user.getRegDate());
            jsonObject.put("profile", user.getProfile());
            jsonArray.add(jsonObject);
        }
		return jsonArray;
	}
}
