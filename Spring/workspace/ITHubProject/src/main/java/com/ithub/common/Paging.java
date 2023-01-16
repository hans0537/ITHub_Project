package com.ithub.common;

public class Paging {

	private final int perPage = 5;		// 페이지당 글 갯수
	private int pageCount;				// 총 페이지 갯수
	private int boardCount;				// 총 글의 갯수
	private int first;					// 현재 페이지의 첫 글의 번호
	private int last;					// 현재 페이지의 끝 글의 번호
	
	private final int perSection = 10;	// 페이지 갯수(번호) (1~10까지 띄우는거)
	private int begin;					// 그 섹션의 시작 페이지
	private int end;					// 그 섹션의 끝 페이지
	private int section;				// 범위 번호 (1~10 :1, 11~20 :2 ..)
	private int page;					// 현재 페이지
	
	private boolean prev;				// 이전
	private boolean next;				// 다음
	
	public Paging(int page, int boardCount) {
		this.page = page;
		this.boardCount = boardCount;
		
		// 총 페이지
		pageCount = boardCount / perPage;					// 20 / 10 = 2 , 넘어가는 페이지 수가 2개인건가?
		pageCount += (boardCount % perPage) == 0 ? 0 : 1;	// 
		
		// 시작 글의 번호 (공식)
		first = (page - 1) * perPage + 1;			// 예) 현재 페이지가 2면 ( 2 - 1) * 10 = 10 + 1 = 11 이라 1~10, 11~20 이런식
		// 끝 글 번호
		last = first + perPage - 1;					// last = 1 + 10 - 1 = 10 / 10번 인것 
		
		section = (page - 1) / perSection; 			// perSection = 10; 페이지가 1~10일 경우는 0의 값 11~20은 1
		// 시작 페이지
		begin = perSection * section + 1;			// 위에서 나온 섹션의 값 -> 0넣으면 1, 1넣으면 11 ..
		// 끝 페이지
		end = begin + perSection - 1;				// 1 + 10 - 1 = 10, 11 + 10 - 1 = 20 / 끝 페이지 10, 20 도출
		end = end > pageCount ? pageCount : end;	 
		
		prev = section != 0;						// 1~10페이지면 이전이 없으니까 필요x?
		next = boardCount > perPage * end;			// 보드카운트가 더 크면 그 다음이 있다는 소리 -> 다음을 띄워준다
		
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPerPage() {
		return perPage;
	}

	public int getPerSection() {
		return perSection;
	}
	
	
	
	
}
