/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.DAO;

import com.mec.models.Passport.Rol;
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
import org.springframework.stereotype.Repository;

/**
 *
 * @author 36194445
 */
@Repository
//@Transactional(readOnly = true,transactionManager = "managerPassport")
public class UserDAO{
    @Autowired
    @Qualifier(value="dataPassport")
    private DataSource ds;
    
    /*public String[] getUserRoles(Integer userID){
        String output = "";
        Query query = getSessionPassport().createSQLQuery(
            "EXEC [SqlSp].[paRolesGetByIdUsuario] :idAplicacion, :idUsuario, :ErrText")
            .setParameter("idAplicacion", 1)
            .setParameter("idUsuario", userID)
            .setParameter("ErrText", output);
        query.setResultTransformer(Transformers.aliasToBean(Rol.class));
        
        List<Rol> result = query.list();
        String roles[] = new String[result.size()];
        for (int i=0;i<result.size();i++) {
            roles[i]=result.get(i).getNombre().toString();
        }
        return roles;
    }*/
    
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
            List<Rol> roles = getUserRoles(userId);
            u = new Usuario(userId,roles);
        }
        return u;
    }
    
     private List<Rol> getUserRoles(Integer userID){
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
        return (List<Rol>)jdbcCall.execute(in).entrySet().iterator().next().getValue();
    }
    
public class MyRowMapper implements RowMapper<Rol>{

        @Override
        public Rol mapRow(ResultSet rs, int i) throws SQLException {
            Rol r = new Rol();
            r.setNombre(rs.getString("Nombre"));
            return r;
        }
    
}
        

}
