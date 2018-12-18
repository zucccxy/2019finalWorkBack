package org.hzqisheng.controller;

import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.util.response.ResponseDataUtil;

@RestController
@Scope("prototype")
@RequestMapping("api/group")
public class Test {
	
	@RequestMapping("as")
	public Map<String,Object> as()throws Exception{
		return ResponseDataUtil.ok().putData("a", 1).build();
	}
}
