package com.su.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.su.member.model.vo.Member;

public class MemberDao {
	
	public Member login(SqlSession sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.login", member);
	}
	
}

/*
 * [selectOne]
 * - 단일 행(한 줄) 조회할 때
 * - 의미 : SQL 실행 결과가 "1개의 행(row)"일 때 사용
 * - 예시 : 로그인, 회원 1명 조회, 게시글 상세보기 등
 * - 반환값 : 단일 객체(예: (vo/기본형) Member, Board, int, String 등)
 * - 트랜잭션 : x
 * - SELECT * FROM MEMBER WHERE USER_ID = 'user01';
 * - MyBatis가 내부에서 자동으로 1행만 매핑해서 반환
 * - 만약 여러 행이 조회되면 TooManyResultsException 발생
 * 
 * [selectList]
 * - 여러 행(리스트) 조회할 때
 * - 의미 : SQL 결과가 "여러 행(row)"일 때 사용
 * - 예시 : 회원 전체 목록, 게시판 목록, 댓글 목록 등
 * - 반환값 : List<vo> 형태
 * - 트랜잭션 : x
 * - SELECT * FROM MEMBER;
 * - 결과가 여러개 -> selectList()
 * - MyBatis가 자동으로 List<Member> 형태로 반환
 * 
 * [insert]
 * - 데이터 삽입할 때
 * - 의미 : "새 데이터"를 "테이블에 추가"할 때 사용
 * - 반환값 : 처리된 행(row)의 개수(int)
 * 			- 예시 : 1행 추가 성공 -> return 1
 * 			- 실패 : return 0
 * - 트랜잭션 : commit() 필요 (Service에서 처리)
 * - INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, 'user01', 'pass01', '홍길동');
 * 
 * 
 * [update]
 * - 데이터 수정할 때
 * - 의미 : "기존 데이터"를 "수정"할 때 사용
 * - 반환값 : 수정된 행 (row) 수(int)
 * - 트랜잭션 : commit() 필요
 * - UPDATE MEMBER SET USER_NAME = '김철수' WHERE USER_ID = 'user01';
 * 
 * [delete]
 * - 데이터 삭제할 때
 * - 의미 : "데이터 삭제"할 때 사용
 * - 반환값 : 삭제된 행(row) 수(int)
 * - 트랜잭션 : commit() 필요
 * - DELETE FROM MEMBER WHERE USER_ID = 'user01';
 * 
 * 
 * 
 */
