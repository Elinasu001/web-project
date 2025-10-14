package com.su.member.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.su.member.model.service.MemberService;
import com.su.member.model.vo.Member;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// vo 생성
		// 로그인
		
		// 1) GET ? POST?
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달 값이 있나 확인 : POST 무조건 해야됨, 클라이언트(jsp, html)에서 서버(controller, servlet) 로 전송된 사용자 입력 값 가져오기 위함.
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		// 3) 데이터 가공 : 사용자가 입력한 데이터를 하나의 객체 형태로 묶어서 다루기 
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		
		// 4) 요청 처리
		Member loginMember = new MemberService().login(member); // 로그인 처리를 위해 개발자가 직접 정의한 메서드
		
		// 확인
		System.out.println(loginMember);
		
		// 5) 응답화면 지정 : 로그인 성공 / 실패
		if(loginMember != null) {
			HttpSession session = request.getSession(); // 현재 요청(request) 과 연결된 세션(HttpSession) 을 가져오는 코드
														// - 만약 이미 로그인한 사용자가 있다면 → 기존 세션을 반환 / 처음 방문한 사용자라면 → 새로운 세션을 생성
														// - session 변수 안에는 이제 현재 사용자 전용 세션 객체가 들어갑니다.
			session.setAttribute("userInfo", loginMember); // 세션 안에 데이터를 저장하는 코드
														   // - "userInfo" → 저장할 때 붙이는 이름(키 이름) / loginMember → 저장할 값(데이터) (보통 로그인 성공 시, DB에서 가져온 회원 객체(Member) 가 들어갑니다.)
														   // - 나중에 꺼내 쓰는 방법 : Member loginUser = (Member) session.getAttribute("userInfo");
		
			// 성공 시 화면
			session.setAttribute("alertMsg", "로그인 성공");
			response.sendRedirect(request.getContextPath());
		
		} else {
			
			// 실패 시 화면
			request.setAttribute("msg", "로그인에 실패했습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/result_page.jsp").forward(request, response);
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}

/*
 * 데이터 가공 방법 : 
 *  단일 객체 (하나의 VO 에 묶어서 전달)
 *  Member member = new Member();
 *  member.setUserId(userId);
 *  member.setUserPwd(userPwd);
 *  service.loginMember(member);
 *  - 로그인, 회원가입, 글작성
 * 
 * 여러 개의 파라미터(필요한 값만 따로 전달)
 * 1. 파라미터 꺼내기 
 * int boardNo = Integer.parseInt(request.getParameter("boardNo"));
 * String boardTitle = request.getParameter("boardTitle");
 * 2. 객체 vo에 담기
 * Board b = new Board();
 * b.setBoardNo(boardNo);
 * b.setBoardTitle(boardTitle);
 * 3. 서비스 호출
 * int result = new BoardService().updateBoard(b);
 * - 게시글 수정, 특정 조건 검색 등
 * 
 * Map 방식 (키 - 쌍)
 * Map<String, Object> map = new HashMap<>();
 * map.put("keyword", keyword);
 * map.put("category", category);
 * map.put("status", status);
 * service.searchBoard(map);
 * - 조건이 많고, 상황에 따라 key/value가 달라질 때, 동적 SQL (<if>, <choose> 등) 사용 시 유용
 * - 검색, 필터, 동적sql 자주 사용
 * 
 * 컬렉션(List, Set 등)
 * List<Integer> boardNoList = Arrays.asList(1, 2, 3);
 * service.deleteBoards(boardNoList);
 * - 같은 형태의 데이터 여러 개를 다룰 때 (반복문 처리)
 * - MyBatis에서 foreach 구문과 함께 사용
 * - 여러 회원 삭제, 파일 리스트 삽입 등
 * 
 * VO 안에 다른 VO를 포함 (연관 객체)
 * public class Board {
	    private int boardNo;
	    private String boardTitle;
	    private Member writer; // 다른 객체 포함
	    private List<Attachment> files; // 컬렉션 포함
	}
 * - 조인 결과를 한 번에 담고 싶을 때
 * - 복잡한 관계형 데이터 (1:N, N:1)를 표현할 때
 * - 게시글 + 첨부파일, 회원 + 권한, 주문 + 상품 등
 */


/*
 * 	[== null] ⭐⭐⭐
 *	if(obj == null )
 * 	객체가 존재하지 않을 때 
 * 	- 메모리에 객체가 아예 없는 경우 ( null pointer 방지 )
 * 	- 즉, 객체 자체가 존재하지 않는 경우
 * 
 *  [!= null]
 *  if(obj != null)
 *  객체가 존재할 때
 *  - 로그인 성공 / 실패 : DB에서 조회된 결과가 없으면 null 반환이므로 null 체크
 *  - 안전하게 필드나 메서드 접근 가능
 *  
 *  [.isEmpty()] ⭐⭐⭐
 *  if(str.isEmpty())
 *  문자열이 ""(빈문자열)인지
 *  - 길이가 0인지 확인 ( null 아님 )
 *  - 객체는 있지만 안에 데이터가 없는 경우
 *  
 *  [.equals()] ⭐⭐⭐
 *  if(str.equals("admin"))
 *  문자열 비교
 *  - 문자열과 동일할 경우 관리자 전용 메뉴 출력
 *  - "=="은 주소 비교, "equals"는 내용 비교
 *  
 *  [.equalsIgnoreCase()]
 *  if(str.equalsIgnoreCase("admin"))
 *  대소문자 구분 없이 비교
 *  - 로그인 ID등 비교 시 유용
 *  
 *  [>, <, >=, <=] ⭐⭐⭐
 *  if(result > 0)
 *  숫자 비교
 *  - 회원가입 성공 / 실패 : DB INSERT UPDATE DELETE 실행 시. result는 적용된 행 개수를 의미하므로 0보다 크면 성공
 *  - DB 결과, count, update 결과 등 판단
 *  - DB 작업이 성공적으로 적용됨
 *  
 *  [== true / false] ⭐⭐⭐
 *  if(flag == true) or if(!flag)
 *  boolean 값 비교
 *  - 상태 플래그 체크
 *  
 *  [list == null + list.isEmpty()]
 *  if(list == null || list.isEmpty() )
 *  - 검색 결과 리스트 조회 없을 경우 / 있을 경우 조회된 게시글 수 
 *  - DB 조회 결과가 없으면 null 또는 비어있을 수 있으므로 둘다 체크
 *  - (list == null) 방어 + (isEmpty()) 데이터 유무 확인
 *  
 *  [title == null + title.isEmptyy()]
 *  if(title == null || title.isEmpty())
 *  - 빈 문자열인지 확인 후 제목 입력 받기
 *  - 사용자가 input칸을 비워서 보냈을 때 null 또는 "" 둘 다 잡아야함
 *  
 *  
 *  [StringUtils.hasText(str)]
 *  (스프링 util)
 *  공백 문자열까지 체크
 *  - " "도 비었다고 판단 가능
 *  
 * 
 */


// 5) 응답화면 지정
// 스탭 1. request 속성에 출력할 값 추가 => setAttribute()
// 스탭 2. RequestDispatcher => 뷰 지정
// 스탭 3. RequestDispatcher이용해서 forward() 호출
// 그럼 로그인된 정보는 로그아웃 전까지 유지 되어야 하니 
// 1. 로그인된 사용자의 정보를 어딘가에 담아야된다.(application, session, request, page)
// 여기서 어디로 담아야 할까? 
/*
 * 크다
 * 1) application : 웹 애플리케이션 전역에서 사용 가능
 * 					(일반 자바 클래스에서 값을 사용할 수 있음)
 * 
 * 2) session : 모든 JSP와 Servlet 에서 꺼내 쓸 수 있음
 * 				단, session에 값이 지워지기 전까지
 * 				세션 종료 시점 : 브라우저 종료, 서버 멈춤, 코드로 지움
 * 				세션과 쿠키 (쿠키는 다음 수업에 배울 예정)
 * 							
 * 
 * 3) request : 해당 request를 포워딩한 응답 JSP에서만 쓸 수 있음
 * 				요청 부터 응답까지만 딱 쓸 수 있음
 * 
 * 4) page : 값을 담은 JSP에서만 쓸 수 있음
 * 작다
 * 
 * => session, request를 많이 사용함
 * 
 * 
 *  HttpSession은 로그인한 사용자의 상태(정보)를 유지하기 위해 사용하는 객체
 *  웹은 기본적으로 요청(request) → 응답(response) 한 번 하고 나면 연결이 끊어지기 때문에,
 *	사용자가 로그인했는지, 누구인지, 어떤 권한이 있는지를 기억할 방법이 없습니다.
 *  그래서 Session은 이런 문제를 해결하기 위해 만들어진 서버 쪽의 임시 저장소예요.
 *  
 *  즉, “사용자별로 서버가 따로 기억해두는 저장 공간”입니다.
 *  
 *  
 */

