package com.scps.werd.service;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import com.scps.werd.model.Supplier;

@Service
public class SupplierService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String add(Supplier supplier) {
        jdbcTemplate.setDataSource(dataSource);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = """
                INSERT INTO werd.tb_supplier(
                create_time, creator, update_time, updater, remark, is_deleted, id, supplier,
                unified_business_no, email,address_1, address_2, head, head_phone_1, head_phone_2,
                contact_person, contact_person_phone_1, contact_person_phone_2, other_contact_1,
                other_contact_2)
                VALUES (now(),?,now(),'',?,false,?,?,?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id;
                """;
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, supplier.creator);
            ps.setString(2, supplier.remark);
            ps.setString(3, supplier.id);
            ps.setString(4, supplier.supplier);
            ps.setString(5, supplier.unifiedBusinessNo);
            ps.setString(6, supplier.email);
            ps.setString(7, supplier.address1);
            ps.setString(8, supplier.address2);
            ps.setString(9, supplier.head);
            ps.setString(10, supplier.headPhone1);
            ps.setString(11, supplier.headPhone2);
            ps.setString(12, supplier.contactPerson);
            ps.setString(13, supplier.contactPersonPhone1);
            ps.setString(14, supplier.contactPersonPhone2);
            ps.setString(15, supplier.otherContact1);
            ps.setString(16, supplier.otherContact2);
            return ps;
        }, keyHolder);
        List<Map<String, Object>> testList = keyHolder.getKeyList();
        System.out.println(testList.get(0).get("id"));
        return testList.get(0).get("id").toString();
    }

    public String tryAddPs(Supplier supplier)throws SQLException{
        //jdbcTemplate.setDataSource(dataSource);
        Connection connection = dataSource.getConnection();
        connection.setSchema("werd");
        //CallableStatement callableStatement = connection.prepareCall("call addsupplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        CallableStatement callableStatement = connection.prepareCall("call add_supplier(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        callableStatement.setString(1, supplier.creator);
        callableStatement.setString(2, supplier.updater);
        callableStatement.setString(3, supplier.remark);
        callableStatement.setString(4, supplier.id);
        callableStatement.setString(5, supplier.supplier);
        callableStatement.setString(6, supplier.unifiedBusinessNo);
        callableStatement.setString(7, supplier.email);
        callableStatement.setString(8, supplier.address1);
        callableStatement.setString(9, supplier.address2);
        callableStatement.setString(10, supplier.head);
        callableStatement.setString(11, supplier.headPhone1);
        callableStatement.setString(12, supplier.headPhone2);
        callableStatement.setString(13, supplier.contactPerson);
        callableStatement.setString(14, supplier.contactPersonPhone1);
        callableStatement.setString(15, supplier.contactPersonPhone2);
        callableStatement.setString(16, supplier.otherContact1);
        callableStatement.setString(17, supplier.otherContact2);
        callableStatement.registerOutParameter(18,Types.VARCHAR );
        callableStatement.execute();
        String o_id = callableStatement.getString(18);
        //System.out.println("o_id: " + o_id);
        return o_id;
    }
}
