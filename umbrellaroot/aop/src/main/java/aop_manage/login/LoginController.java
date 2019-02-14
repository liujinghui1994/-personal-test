package aop_manage.login;

import aop_manage.aop_annotation.VerifyLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("login")
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private static boolean login = false;

	@Autowired
    private ProductManage productManage;

    /**
     * 登陆页面
     * @param request
     * @return
     * @throws Exception
     */

    @RequestMapping("/loginPage")
    public String loginPage(HttpServletRequest request) throws Exception {
        return "login";
    }


    /**
     * 访问主页
     */
    @RequestMapping("/doMainIndex")
    public String doMainIndex(String id) throws Exception {
        System.out.println("执行访问主页方法"+id);
        return "main";
    }
    /**
     * 退出主页
     */
    @RequestMapping("/doQuit")
    public String doQuit(int id) throws Exception {
        System.out.println("执行退出主页方法"+id);
        return "main";
    }
}
