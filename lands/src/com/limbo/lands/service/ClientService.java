package com.limbo.lands.service;

import com.limbo.lands.dao.ClientDao;
import com.limbo.lands.domain.Client;
import com.limbo.lands.domain.PageBean;

import java.sql.SQLException;

/**
 * Created by lenovo on 2016/4/17.
 */
public class ClientService {
    private ClientDao clientDao=new ClientDao();

    /**
     * 查询客户信息
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Client> findAllClient(int pcode, int psize) {
        try {
            return clientDao.findAllClient(pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public PageBean<Client> findClientByClnameAndEnname(int pcode, int psize, String en_id, String clname) {

        try {
            return clientDao. findClientByClnameAndEnname(pcode,psize,en_id,clname);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 客户明细
     * @param cl_id
     * @return
     */
    public Client findClientDetail(String cl_id) {
        return clientDao.findClenDetail(cl_id);

    }
}
