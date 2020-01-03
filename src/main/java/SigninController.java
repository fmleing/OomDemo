/**
 * ‎Hangzhou Lejian Technology Co., Ltd.
 * Copyright (c) 2019 All Rights Reserved.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 用户注册入口
 * 
 * @author Your Name
 *
 */
//@Controller
public class SigninController {

	// 使用Map做内存缓存，key是手机号，value是用户对象
	private static Map<String, User> userMap = new HashMap<>();

	public static void main(String[] args) {
		//register("138 1234 1234");
		//register("13812345abc");
		register("13812345678");
		register("138 1234 5678");
		//register("98765432101");
		/**
		 * TODO 请从这里开始补充代码
		 *
		 * 测试1：138 1234 1234
		 *	结果：通过此手机号注册成功
		 *
		 * 测试2：13812345abc
		 *	结果：通知本手机号无法注册，提示为非法手机号
		 *
		 * 测试3：13812345678
		 *	结果：通知此手机号注册成功
		 *
		 * 测试4：138 1234 5678
		 *	结果：提示此手机号已经被其他用户注册
		 *
		 * 测试5：98765432101
		 *	结果：此手机号码为中国大陆非法手机号码
		 */
	}



	/**
	 * 注册手机号
	 * @param phoneNum 手机号
	 */
	public static void register(String phoneNum) {
		try {
			phoneNum = PhoneUtil.format(phoneNum);
			if (PhoneUtil.checkIsNumber(phoneNum)) {
				if (PhoneUtil.checkIsPhone(phoneNum)) {

					boolean contains = userMap.containsKey(phoneNum);
					if (contains) {
						System.out.println("此手机号已经被其他用户注册。");
					} else {
						userMap.put(phoneNum, new User(phoneNum));
						System.out.println("通过此手机号注册成功。");
					}
				}else{
					System.out.println("此手机号码为中国大陆非法手机号码。");
				}
			}else{
				System.out.println("通知本手机号无法注册，提示为非法手机号。");
			}
		} catch (Exception e) {
			System.out.println("注册异常！");
		}
	}
}

class User{
	private String phoneNum;

	public User() {
	}

	public User(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}

class PhoneUtil {

	/**
	 * 校验手机号码是否正确
	 * @param phoneNum
	 * @return
	 */
	public static boolean checkIsPhone(String phoneNum) {
		return phoneNum.matches("1(3[0-9]|5[189]|8[6789])( )?[0-9]{4}( )?[0-9]{4}");
	}

	/**
	 * 校验是否为号码
	 * @param phoneNum 手机号
	 * @return
	 */
	public static boolean checkIsNumber(String phoneNum) {
		return phoneNum.matches("-?[0-9]+(\\\\.[0-9]+)?");
	}

	/**
	 * 格式化手机号，去除空格
	 * @param phoneNum 手机号
	 * @return
	 */
	public static String format(String phoneNum){
		return phoneNum.replaceAll("\\s*", "");
	}

}

