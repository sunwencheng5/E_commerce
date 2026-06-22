package com.lwzy.util;

import com.lwzy.bean.before.Buser;
import jakarta.servlet.http.HttpSession;

import java.util.Random;

public class MyUtil {
	public static Buser getBuserFromSession(HttpSession session) {
		Buser buser = (Buser)session.getAttribute("user");
		return buser;
	}
	public static String getRandomStr(int n) {
		// 生成 Random 对象
		Random random = new Random();
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < n; i++) {
			// 生成 0-9 随机整数 
			str = str.append(random.nextInt(10)); 
		} 
		return str.toString();
	}
}
