package aop_manage.login;

import org.springframework.stereotype.Service;

/**
 * @program: aop_manage.login
 * @description:
 * @author: liujinghui
 * @create: 2019-02-10 16:18
 **/
@Service
public class ProductManage implements ProductManageInterface {
    @Override
    public void add() {
        System.out.println("添加商品");
    }

    @Override
    public void sale() {
        System.out.println("卖出商品");
    }
}
