package ktds.erp.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	@Autowired
	FileUploadLogic uploadservice;

	//게시글 db에 insert
	//1. 스프링 mvc내부에서 갑을 검증하는 경우에는 반드시 @valid를 검증할 dto에선언
	//   @valid를 이용해서 값을 검증하는 경우 Error가 발생되었는지 정상처리되었는지 
	//	결과를담을 수 있는 Errors객체를 같이 선언해야 한다.
	//2. 검증한 객체를 Command 객체라 하며 이 객체를 view로 전달해 주는 작업을
	//   해야 하므로 반드시 ModelAndView를 리턴하도록
	@RequestMapping(value="/board/user/insert.do" ,method=RequestMethod.POST)
	public ModelAndView write(@Valid BoardDTO boardDTO,Errors error,HttpServletRequest req) throws Exception{
		//board dto에는 사용자가 게시글로 등록하는 일반적인내용과
		//업로드하는 파일의 정보
		//1. dto에서 업로드되는 파일의 모든 정보를 추출
		//  => 파일 여러 개일 수 있으므로 ArrayList에 담기
		//  => FileUploadLogic이 업로드되는 파일갯수호출		//  		
		//System.out.println(board);
		//System.out.println(board.getFiles().length);
		ModelAndView mav=new ModelAndView();
		
		if(error.hasErrors()) {
			mav.setViewName("board/write");
			return mav;
			//if문 앞에서 리턴하는 이유는 에러가 발생되면
			//더 진행시키지 않고 입력폼으로 되돌아가기 위해서
		}
		
		
		MultipartFile[] files = boardDTO.getFiles();
		//저장위치 - 서버가 인식하는 위치
		String path = WebUtils.getRealPath(req.getSession().getServletContext(), "/WEB-INF/upload");
		ArrayList<String> filelist = new ArrayList<String>();
			
		for(int i=0; i<files.length; i++) {
			String fileName = files[i].getOriginalFilename();
			//System.out.println(fileName);
			if(fileName.length()!=0) {
				//파일명을 ArrayList에 추가
				filelist.add(fileName);
				//업로드 - 서비스단에서작업
				uploadservice.upload(files[i], path, fileName);
				//서비스의 DB관련 메소드 호출				
			}			
		}	
		//서비스의 디비관련메소드 호출
		service.insert(boardDTO, filelist);
		mav.setViewName("redirect:/board/list.do?category=all");
		return mav;//성공했을때 - 입력값 검증 성공
	}	
	
	@RequestMapping(value="/board/list.do")
	public ModelAndView showlist(String category) {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> boardlist = service.boardList(category);
		System.out.println("category====>"+category);
		
		mav.addObject("category",category);
		mav.addObject("boardlist",boardlist);
		mav.setViewName("board/list");//tiles에 등록
		return mav;
	}

	@RequestMapping(value="/board/user/read.do")
	public ModelAndView read(String board_no,String state) {
		System.out.println("readcontroller=>"+board_no+","+state);
		BoardDTO board= service.read(board_no);
		System.out.println("조회된 데이터 =>"+board);
		String viewName="";
		if(state.equals("READ")) {
			viewName = "board/read";
		}else {
			viewName = "board/update";
		}
		//System.out.println(model);
		ModelAndView mav=new ModelAndView();
		mav.addObject("board",board);
		//System.out.println(model);
		mav.setViewName(viewName);
		return mav;
	}
	@RequestMapping(value="/board/update.do",method=RequestMethod.POST)
	public String update(BoardDTO board) {
		System.out.println(board);
		int result = service.update(board);
		System.out.println(result+"개 행 수정성공!!");
		return "redirect:/board/list.do?category=all";
	}
	@RequestMapping(value="/board/delete.do")
	public String delete(String board_no) {
		System.out.println("readcontroller=>"+board_no);
		ModelAndView mav = new ModelAndView();
		int result= service.delete(board_no);
		System.out.println(result+"개 행 삭제성공!!");
		return "redirect:/board/list.do?category=all";
	}
	@RequestMapping(value="/board/search.do")
	public ModelAndView search(String tag,String search) {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> boardlist = service.dynamicSearch(tag, search);
		mav.addObject("boardlist",boardlist);
		mav.setViewName("board/list");//tiles에 등록
		return mav;
	}
	//일반 메소드 리턴하는 것처럼 List<BoardDTO>를 리턴하면서
	//@ResponseBody로 설정하면 jackson라이브러리가 자동으로 json객체로 변환
	@RequestMapping(value = "/board/ajax_boardlist.do",
			method=RequestMethod.GET,
			produces="application/json;charset=utf-8")
	public @ResponseBody List<BoardDTO> categoryboardlist(
													String category) {
		String result = "";
		List<BoardDTO> boardlist = service.boardList(category);
		System.out.println("ajax통신"+boardlist);
		return boardlist;
	}
}



















