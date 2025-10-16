package com.su.breacrumb.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.su.breacrumb.model.vo.BreadcrumbItem;

/**
 * 페이지별 브레드크럼 데이터를 공통 관리하는 유틸 클래스
 */
public class BreadcrumbUtil {

    /**
     * 페이지 키워드에 따라 브레드크럼 목록을 생성하고 request에 저장
     * @param request 현재 요청 객체
     * @param pageKey 페이지 구분 키워드 (예: "login", "signup", "notice")
     */
    public static void setBreadcrumb(HttpServletRequest request, String pageKey) {
        List<BreadcrumbItem> breadcrumbs = new ArrayList<>();

        switch (pageKey) {
            case "login":
                breadcrumbs.add(new BreadcrumbItem("홈", "/"));
                breadcrumbs.add(new BreadcrumbItem("로그인", null));
                break;

            case "signup":
                breadcrumbs.add(new BreadcrumbItem("홈", "/"));
                breadcrumbs.add(new BreadcrumbItem("회원가입", null));
                break;

            case "boards":
                breadcrumbs.add(new BreadcrumbItem("홈", "/"));
                breadcrumbs.add(new BreadcrumbItem("고객지원", null));
                breadcrumbs.add(new BreadcrumbItem("자유 게시판", null));
                break;

            default:
                breadcrumbs.add(new BreadcrumbItem("홈", "/"));
                break;
        }

        // JSP에서 사용할 수 있도록 request에 담기
        request.setAttribute("breadcrumbs", breadcrumbs);
    }
}
