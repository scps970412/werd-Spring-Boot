package com.scps.werd.service;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.scps.werd.model.Supplier;

@Service
public class SupplierService {
    @Autowired
    private DataSource dataSource;

    public String add(Supplier supplier) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setSchema("werd");
        CallableStatement callableStatement = connection
                .prepareCall("call add_supplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        callableStatement.setString(1, supplier.getCreator());
        callableStatement.setString(2, supplier.getUpdater());
        callableStatement.setString(3, supplier.getRemark());
        callableStatement.setString(4, supplier.getSupplier());
        callableStatement.setString(5, supplier.getUnifiedBusinessNo());
        callableStatement.setString(6, supplier.getEmail());
        callableStatement.setString(7, supplier.getAddress1());
        callableStatement.setString(8, supplier.getAddress2());
        callableStatement.setString(9, supplier.getHead());
        callableStatement.setString(10, supplier.getHeadPhone1());
        callableStatement.setString(11, supplier.getHeadPhone2());
        callableStatement.setString(12, supplier.getContactPerson());
        callableStatement.setString(13, supplier.getContactPersonPhone1());
        callableStatement.setString(14, supplier.getContactPersonPhone2());
        callableStatement.setString(15, supplier.getOtherContact1());
        callableStatement.setString(16, supplier.getOtherContact2());
        callableStatement.registerOutParameter(17, Types.VARCHAR);
        callableStatement.execute();
        String o_id = callableStatement.getString(17);
        return o_id;
    }

    public boolean updata(Supplier supplier) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setSchema("werd");
        CallableStatement callableStatement = connection
                .prepareCall("call upd_supplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        callableStatement.setString(1, supplier.getUpdater());
        callableStatement.setString(2, supplier.getRemark());
        callableStatement.setString(3, supplier.getId());
        callableStatement.setString(4, supplier.getSupplier());
        callableStatement.setString(5, supplier.getUnifiedBusinessNo());
        callableStatement.setString(6, supplier.getEmail());
        callableStatement.setString(7, supplier.getAddress1());
        callableStatement.setString(8, supplier.getAddress2());
        callableStatement.setString(9, supplier.getHead());
        callableStatement.setString(10, supplier.getHeadPhone1());
        callableStatement.setString(11, supplier.getHeadPhone2());
        callableStatement.setString(12, supplier.getContactPerson());
        callableStatement.setString(13, supplier.getContactPersonPhone1());
        callableStatement.setString(14, supplier.getContactPersonPhone2());
        callableStatement.setString(15, supplier.getOtherContact1());
        callableStatement.setString(16, supplier.getOtherContact2());
        callableStatement.registerOutParameter(17, Types.INTEGER);
        callableStatement.execute();

        int updatedRow = callableStatement.getInt(17);
        if (updatedRow > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Supplier supplier) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setSchema("werd");
        CallableStatement callableStatement = connection.prepareCall("call del_supplier(?,?,?)");
        callableStatement.setString(1, supplier.getId());
        callableStatement.setString(2, supplier.getUpdater());
        callableStatement.registerOutParameter(3, Types.INTEGER);
        callableStatement.execute();

        int deleteRow = callableStatement.getInt(3);
        if (deleteRow > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Supplier getById(String id) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setSchema("werd");
        connection.setAutoCommit(false);
        CallableStatement callableStatement = connection.prepareCall("call get_supplier(?,?)");
        callableStatement.setString(1, id);
        callableStatement.registerOutParameter(2, Types.REF_CURSOR);
        callableStatement.execute();
        ResultSet rs = (ResultSet) callableStatement.getObject(2);
        Supplier supplier = new Supplier();
        while (rs.next()) {
            supplier.setId(id);
            supplier.setCreator(rs.getString("creator"));
            supplier.setUpdater(rs.getString("updater"));
            supplier.setRemark(rs.getString("remark"));
            supplier.setSupplier(rs.getString("supplier"));
            supplier.setUnifiedBusinessNo(rs.getString("unified_business_no"));
            supplier.setEmail(rs.getString("email"));
            supplier.setAddress1(rs.getString("address_1"));
            supplier.setAddress2(rs.getString("address_2"));
            supplier.setHead(rs.getString("head"));
            supplier.setHeadPhone1(rs.getString("head_phone_1"));
            supplier.setHeadPhone2(rs.getString("head_phone_2"));
            supplier.setContactPerson(rs.getString("contact_person"));
            supplier.setContactPersonPhone1(rs.getString("contact_person_phone_1"));
            supplier.setContactPersonPhone2(rs.getString("contact_person_phone_2"));
            supplier.setOtherContact1(rs.getString("other_contact_1"));
            supplier.setOtherContact2(rs.getString("other_contact_2"));
        }

        return supplier;
    }
}
