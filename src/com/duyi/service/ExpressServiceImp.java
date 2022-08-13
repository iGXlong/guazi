package com.duyi.service;

import com.duyi.bean.Express;
import com.duyi.dao.BaseExpressDao;
import com.duyi.dao.ExpressDaoImp;

import java.util.List;

public class ExpressServiceImp implements BaseExpressService {

    private static BaseExpressDao dao = new ExpressDaoImp();

    /**
     * 查询所有快递信息
     *
     * @return 返回查询到的所有快递对象
     */
    @Override
    public List<Express> findAll() {
        return dao.findAll();
    }

    /**
     * 根据id删除快递信息
     *
     * @param id 要删除的快递id
     * @return 删除的结果 ,true表示成功
     */
    @Override
    public boolean deleteById(int id) {
        return dao.deleteByIdOrENumber(null,id);
    }

    /**
     * 用于操作dao向数据库插入快递数据
     *
     * @param e 要插入的快递数据
     * @return 插入成功时返回取件码, 插入失败时返回null
     */
    @Override
    public String insert(Express e) {
        return dao.insert(e);
    }

    /**
     * 通过快递单号 操作dao 从数据库中查询一个快递信息
     *
     * @param number 要查询的快递单号
     * @return 查询的结果, 查询失败返回null
     */
    @Override
    public Express findByENumber(String number) {
        return dao.findByENumber(number);
    }

    /**
     * 修改快递信息 通过id
     *
     * @param id 要修改的快递id
     * @param e  新的快递数据对象, 包含单号,快递公司,姓名,手机号
     * @return 修改的结果
     */
    @Override
    public boolean updateById(int id, Express e) {
        return dao.updateByIdOrENumber(null,id,e);
    }

    /**
     * 通过取件码查询快递
     *
     * @param code
     * @return 快递对象
     */
    @Override
    public Express findByCode(String code) {
        return dao.findByCode(code);
    }

    /**
     * 查询所有快递数量
     *
     * @return
     */
    @Override
    public int size() {
        return dao.size();
    }

    /**
     * 根据快递状态查询所有快递数量
     *
     * @param status 0表示查询未取件快递数量   1表示查询已取走快递数量
     * @return 结果
     */
    @Override
    public int statusSize(int status) {
        return dao.statusSize(status);
    }

    /**
     * 通过用户的手机号, 查询用户所有快递
     *
     * @param userPhone 用户手机号码
     * @return 包含用户所有快递的集合
     */
    @Override
    public List<Express> findByUserPhone(String userPhone) {
        return dao.findByUserPhone(userPhone);
    }

    /**
     * 根据取件码 修改快递状态为已取件, 修改取件时间为当前时间
     *
     * @param code 取件码
     * @return 取件的结果, true表示取件成功, false表示取件失败
     */
    @Override
    public boolean updateStatusByCode(String code) {
        return dao.updateStatusByCode(code);
    }
}
