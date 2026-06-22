package com.lwzy.bean.before;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buser {
	private int id;
	private String bemail;
	private String bpwd;
	private String code;//验证码
}
