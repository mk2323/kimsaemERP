package ktds.erp.board;

import java.sql.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
//간단한 데이터 검증은 dto에 직접 표현하고
//그렇지 않은 경우 컨트롤러에서 조절하도록
//검증을 위해 제공하는 annotation을 적용하면 dto객체가 만들어질때 값을 검증한다.
public class BoardDTO {
	String board_no;	
	@Pattern(regexp="[A-z0-9]")
	String id;
	@NotEmpty(message="제목은 반드시 입력 ")
	String title;
	@NotEmpty(message="내용은 반드시 입력 ")
	String content;
	Date write_date;
	@NotEmpty
	String category;
	MultipartFile[] files;
	public BoardDTO(){
		
	}

	

	public BoardDTO(String board_no, String id, String title, String content, Date write_date, String category,
			MultipartFile[] files) {
		super();
		this.board_no = board_no;
		this.id = id;
		this.title = title;
		this.content = content;
		this.write_date = write_date;
		this.category = category;
		this.files = files;
	}



	public MultipartFile[] getFiles() {
		return files;
	}



	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}



	public String getBoard_no() {
		return board_no;
	}

	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BoardDTO [board_no=" + board_no + ", id=" + id + ", title=" + title + ", content=" + content
				+ ", write_date=" + write_date + ", category=" + category + "]";
	}
	
	
}
