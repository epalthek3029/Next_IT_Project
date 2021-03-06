package kr.or.next.nextit.session.service.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.next.nextit.session.service.LoginInfoVo;
import kr.or.next.nextit.session.service.SessionService;

@Service("sessionService")
public class SessionServiceImpl implements SessionService{

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SessionMapper sessionMapper;
	
	@Override
	public LoginInfoVo selectMemberInfo(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		log.debug("컨트롤 에서 넘어온 값 {}", params);
		
		try {
			return sessionMapper.selectMemberInfo(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage(), e);
			
			return null;
		}
	}
}
