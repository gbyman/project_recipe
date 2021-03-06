package utility;

public class recipePaging {
	//페이징 관련 변수
	private int totalCount = 0 ; //총 레코드 건수
	private int totalPage = 0 ; //전체 페이지 수
	private int pageNumber = 0 ; //보여줄 페이지 넘버(표현 가능한 페이지는 1부터 totalPage까지)
	private int pageSize = 0 ; //한 페이지에 보여줄 건수 
	private int beginRow = 0 ; //현재 페이지의 시작 행
	private int endRow = 0 ; //현재 페이지의 끝 행 
	private int pageCount = 3 ; //보여줄 페이지 링크 수
	private int beginPage = 0 ; //페이징 처리 시작 페이지 번호
	private int endPage = 0 ; //페이징 처리 끝 페이지 번호
	private int offset = 0 ;
	private int limit = 0 ;
	private String url = "" ; 
	private String pagingHtml = "";//하단의 숫자 페이지 링크
	
	private String theme;
	private String keyword;
	private String what;
	
	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getBeginRow() {
		return beginRow;
	}


	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}


	public int getEndRow() {
		return endRow;
	}


	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getBeginPage() {
		return beginPage;
	}


	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getOffset() {
		return offset;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}


	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getPagingHtml() {
		System.out.println("pagingHtml:"+pagingHtml);
		return pagingHtml;
	}


	public void setPagingHtml(String pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
	

	public String getTheme() {
		return theme;
	}


	public void setTheme(String theme) {
		this.theme = theme;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public recipePaging(
			String _pageNumber, 
			String _pageSize,  
			int totalCount,
			String url, 
			String theme,
			String keyword,
			String what) {		

		if(  _pageNumber == null || _pageNumber.equals("null") || _pageNumber.equals("")  ){
			// _pageNumber == null 만 써도 가능
			System.out.println("_pageNumber:"+_pageNumber);
			_pageNumber = "1" ;
		}
		
		this.pageNumber = Integer.parseInt( _pageNumber ) ; 

		if( _pageSize == null || _pageSize.equals("null") || _pageSize.equals("") ){
			//  _pageSize == null 만 써도 가능
			_pageSize = "9" ;
		}		
		
		this.pageSize = Integer.parseInt( _pageSize ) ;

		this.offset = ( pageNumber - 1 ) * pageSize ; 
		/*offset : 건너뛸 레코드 갯수
			한 페이지에 2개씩 출력할 때,
			3페이지 클릭하면 앞에 4개 건너뛰고 5번째 부터 나와야 한다. 
			위의 offset = (3-1)*2 => 4(건너뛸 갯수가 된다.)
		*/	
		this.limit = pageSize ; // 한 페이지에 보여줄 갯수

		this.totalCount = totalCount ; 

		this.totalPage = (int)Math.ceil((double)this.totalCount / this.pageSize) ;
		//  ceil(6/5) => 2의 값이 totalPage에 들어간다.
		
		this.beginRow = ( this.pageNumber - 1 )  * this.pageSize  + 1 ;
		this.endRow =  this.pageNumber * this.pageSize ;
		// pageNumber가 2이면 beginRow=6, endRow=10
		
		if( this.endRow > this.totalCount ){
			this.endRow = this.totalCount  ;
		}

		this.beginPage = ( this.pageNumber - 1 ) / this.pageCount * this.pageCount + 1  ;
		this.endPage = this.beginPage + this.pageCount - 1 ;
		/*pageCount=10 : 한 화면에 보일 페이지 수,
		pageNumber(현재 클릭한 페이지 수)가 12이면 beginPage = 11이 되고, endPage=20이 된다. */
				
		if( this.endPage > this.totalPage ){
			this.endPage = this.totalPage ;
		}

		this.url = url ; //  /ex/list.ab
		this.theme = theme ;
		
		this.pagingHtml = getPagingHtml(url) ;
		//[이전]456[다음]
	
	}
	
	private String getPagingHtml( String url ){ //페이지를 문자열로 만든다.
		System.out.println("getPagingHtml url:"+url); 
		
		String result = "<ul class='pagination justify-content-center'>"; 
		
		String added_param = "&theme=" + theme + "&keyword=" + keyword + "&what=" + what;
		
		if (this.beginPage != 1) { //앞쪽, pageSize:한 화면에 보이는 레코드 수
			// 처음 목록보기를 하면 pageNumber는 1이 되고 beginPage도 1이 된다. 
			result+="<li class='page-item'>" + 
					"<a class='page-link' href='"+ url  
					+ "?pageNumber=" + ( 1 ) + "&pageSize=" + this.pageSize+"' aria-label='Previous'>" + 
					"<span aria-hidden='true'>맨처음</span>" + 
					"</a></li>";
			result+="<li class='page-item'>" + 
					"<a class='page-link' href='"+ url 
					+ "?pageNumber=" + (this.beginPage - 1 ) + "&pageSize=" + this.pageSize 
					+ added_param +"' aria-label='Previous'>" + 
					"<span aria-hidden='true'>이전</span>" + 
					"</a></li>";
		}
		
		//가운데
		for (int i = this.beginPage; i <= this.endPage ; i++) {
			
			result+="<li class='page-item'>";
			result+="<a class='page-link' href='"+url   
					+ "?pageNumber=" + i + "&pageSize=" + this.pageSize 
					+ added_param+"'>"+i+"</a>"; 
			result+="</li>";
		}
		
		System.out.println("result:"+result); // 가운데 부분
		System.out.println();
		
		if ( this.endPage != this.totalPage) { // 뒤 쪽
			// endPage:지금 보는 페이지의 끝(지금 보는 페이지가 13이라면 endPage는 20), totalPage:전체페이지 수
			result+="<li class='page-item'>" + 
					"<a class='page-link' href='"+ url  
					+ "?pageNumber=" + (this.endPage + 1 ) + "&pageSize=" + this.pageSize 
					+ added_param +"' aria-label='Next'>" + 
					"<span aria-hidden='true'>다음</span>" + 
					"</a></li>";
			result+="<li class='page-item'>" + 
					"<a class='page-link' href='"+ url  
					+ "?pageNumber=" + (this.totalPage ) + "&pageSize=" + this.pageSize 
					+ added_param +"' aria-label='Next'>" + 
					"<span aria-hidden='true'>맨 끝</span>" + 
					"</a></li>";
			
		}		
		result+="</ul>";
		
		return result ;
	}	
	
}

