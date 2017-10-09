/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.models.Passport.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 36194445
 */
@Repository
public class UserDAO{
    @Autowired
    @Qualifier(value="dataPassport")
    private DataSource ds;
    
    public Usuario getUser(String nombre,String clave){
        Usuario u = null;
         SimpleJdbcCall jdbcCall =  new SimpleJdbcCall(ds)
                 .withCatalogName("dbo")
                 .withProcedureName("paValidarUsuario")
                 .withoutProcedureColumnMetaDataAccess()
                 .declareParameters(new SqlParameter("NombreUsuario", Types.VARCHAR))
                 .declareParameters(new SqlParameter("Clave", Types.VARCHAR))
                 .declareParameters(new SqlOutParameter("UserId", Types.INTEGER))
                 .declareParameters(new SqlOutParameter("ErrText", Types.VARCHAR));
        SqlParameterSource in = new MapSqlParameterSource().addValue("NombreUsuario", nombre).addValue("Clave", clave);
        Map<String,Object> r = jdbcCall.execute(in);
        Integer userId = null;
        String errText = "";
        for (Map.Entry<String, Object> entry : r.entrySet()) {
            String key = entry.getKey();
            if(key.equals("UserId")){
                userId = (Integer)entry.getValue();
            }else if(key.equals("ErrText")){
                errText = (String)entry.getValue();
            }
        }
        if(userId!=null && errText.equals("Ok")){
            List<GrantedAuthority> roles = getUserRoles(userId);
            u = new Usuario(userId,roles);
        }
        return u;
    }
    
     public List<GrantedAuthority> getUserRoles(Integer userID){
         SimpleJdbcCall jdbcCall =  new SimpleJdbcCall(ds)
                 .withCatalogName("SqlSp")
                 .withProcedureName("paRolesGetByIdUsuario")
                 .withoutProcedureColumnMetaDataAccess()
                 .declareParameters(new SqlParameter("idAplicacion", Types.INTEGER))
                 .declareParameters(new SqlParameter("idUsuario", Types.INTEGER))
                 .declareParameters(new SqlOutParameter("ErrText", Types.VARCHAR))
                 .returningResultSet("items", new MyRowMapper());
        SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("idAplicacion", 1)
                    .addValue("idUsuario", userID);
        return (List<GrantedAuthority>)jdbcCall.execute(in).entrySet().iterator().next().getValue();
    }
    
public class MyRowMapper implements RowMapper<SimpleGrantedAuthority>{

        @Override
        public SimpleGrantedAuthority mapRow(ResultSet rs, int i) throws SQLException {
            return new SimpleGrantedAuthority("ROLE_"+rs.getString("Nombre"));
        }
    
}
        

}
