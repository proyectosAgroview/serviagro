package co.com.arcosoft.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import co.com.arcosoft.utilities.DriverManagerDataSourceUtils;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Component("zathuraCodeAuthenticationProvider")
public class ZathuraCodeAuthenticationProvider implements AuthenticationProvider {
    /**
     * Security Implementation
     */

    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String name = authentication.getName();
        UserDetails ud = userDetailsService().loadUserByUsername(name);

        if(ud !=null) {
            
        	String password = authentication.getCredentials().toString();
            //String passInputLogin = passwordEncoderGenerator(password);
            String pass = ud.getPassword();
            
            if(passwordEncoder.matches(password, pass)) {
	
            	final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	            for (GrantedAuthority role: ud.getAuthorities()) {
	                grantedAuths.add(new SimpleGrantedAuthority(role.getAuthority()));
	            }
	            
	            //return new UsernamePasswordAuthenticationToken(name,password, grantedAuths);

	           final UserDetails principal = new User(name, password, grantedAuths);
	           final Authentication auth = new UsernamePasswordAuthenticationToken(principal,
	            		password, grantedAuths);

	            return auth;
            	
            }else {
                throw new BadCredentialsException("External system authentication failed");
            }

        }
        
        return null;

    }
    
	public String passwordEncoderGenerator(String password) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
		String hashedPassword = passwordEncoder.encode(password);

		return hashedPassword;
	}


    public UserDetailsService userDetailsService() {

    	String usersByUsernameQuery = "select login as username,  contrasena as password, enabled, compania_id \r\n" + 
    			"                       from usuarios where login =? and enabled ='true'";
    	String authoritiesByUsernameQuery ="select  g.id, g.group_name, ga.authority  from groups g, group_members gm, group_authorities ga, usuarios u " + 
    			"							 where u.login = ? and u.usuario_id = gm.usuario_id and g.id = ga.group_id and g.id = gm.group_id ";

    	JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
    	jdbcDaoImpl.setDataSource(DriverManagerDataSourceUtils.getDatasource());
    	jdbcDaoImpl.setUsersByUsernameQuery(usersByUsernameQuery);
    	jdbcDaoImpl.setGroupAuthoritiesByUsernameQuery(authoritiesByUsernameQuery);
    	jdbcDaoImpl.setEnableGroups(true);
    	jdbcDaoImpl.setEnableAuthorities(false);
    	return jdbcDaoImpl;
    	
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
