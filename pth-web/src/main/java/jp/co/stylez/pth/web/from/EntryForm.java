package jp.co.stylez.pth.web.from;

import java.io.Serializable;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class EntryForm implements Serializable {
	
	private static final  long serialVersionUID = 1L;
	
	@NotBlank(message="入力してください")
	@Length(max=60, message="60文字以下で入力してください")
	@Email(message="入力されたメールアドレスの形式が正しくありません")
	private String email;

	@NotBlank(message="入力してください")
	@Length(min=6, max=12, message="パスワードは6文字から12文字の英数字で入力してください")
	@Pattern(regexp="^[a-zA-Z0-9]+$", message="パスワードに使用できるのは英数字のみです")
	private String password;
	
	private String userName;
	public String getEmail () {
		return this.email;
	}

	public void setEmail (String email) {
		this.email = email;
	}

	public String getPassword () {
		return this.password;
	}

	public void setPassword (String password) {
		this.password = password;
	}

	public String getUserName () {
		return this.userName;
	}

	public void setUserName (String userName) {
		this.userName = userName;
	}
}