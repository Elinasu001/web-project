package com.su.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.su.member.common.Template;
import com.su.member.model.dao.MemberDao;
import com.su.member.model.vo.Member;

public class MemberService {
	private MemberDao md = new MemberDao();
	
	// 로그인
	public Member login(Member member) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginMember = md.login(sqlSession, member);
		
		sqlSession.close();
		
		return loginMember;
		
	}
	
	// 아이디 검증 로직
	// 분리된 로직은 원래 다른 페이지로 ! 일단, 이 페이지로 진행
	public void validateMember(Member member) {
		// ★★★★★★★★★
		// [ 아이디 검증 로직 ]
		// 아이디 : 값이 없거나 space 로 들어 올 경우
		if(member.getUserId() == null || member.getUserId().trim().isEmpty()) {
			return;
		}
		// 아이디 :  값이 있는데 문자로 들어올 경우
		String pattern = "^[a-zA-Z0-9] {4,20}$";
		
		if(!member.getUserId().matches(pattern)) {
			return;
		}
	}
	
	// 회원가입
	public int signUp(Member member) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = md.signUp(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	// 아이디 중복체크
	public String checkId(String id) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		String result = md.checkId(sqlSession, id);
		
		sqlSession.close();
		
		return result;
	}
	
}

//SqlSession 이란?
// - MyBatis에서 DB와 연결(커넥션)을 담당하는 핵심 객체.
// - JDBC의 Connection, PreparedStatement, ResultSet을 대신 관리함.
// - 즉, MyBatis가 SQL 실행과 자원 해제를 자동으로 처리하는 "세션" 개념임.

// 왜 Template.getSqlSession()을 쓰는가?
// - 매번 직접 SqlSessionFactory를 생성하는 코드를 반복하지 않기 위해
//   공통 유틸(Template)에서 세션 생성 로직을 한 번만 정의해둠.

// SqlSession의 특징
// - "매 요청마다 새로 만들어야 하는 자원" (각 요청마다 독립적인 커넥션)
// - 하나의 DB 연결을 점유하므로, 사용이 끝나면 반드시 close() 해야 함.

// 계층별 역할 정리
// - Template  : SqlSession 생성 (공통 유틸 클래스)
// - Service   : SqlSession 생성 및 트랜잭션(commit / rollback) 관리
// - DAO       : 전달받은 SqlSession으로 실제 SQL 실행

// 이렇게 전역에 아닌 메서드 내부 선언 할 경우 좋은 점은 ?
// - 닫힌 세션을 재사용 하는 위험이 없다.
// - 트랜잭션 안정성이 좋다. 즉, 독립적 관리가 가능하다.
// - 동시 요청 처리 시 안전하다. 즉, 스레드 충돌 가능이 없다.
