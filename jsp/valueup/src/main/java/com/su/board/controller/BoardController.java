package com.su.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardController {
	
	 public String boards(HttpServletRequest request, HttpServletResponse response) {
        return "/WEB-INF/views/board/board_list.jsp";
    }
}
