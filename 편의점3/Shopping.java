package 편의점3;

public class Shopping {
	private String no;      //물품 번호
	private String title;   //물품 이름
	private int code;      //물품 코드
	private int price;     //물품 가격
	private String area;    //물품 원산지
	private int amount;     //물품 재고
	private String adult;   //물품 성인
	private int date;       //물품 유통기한
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getAdult(){
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	@Override
	public String toString() {                          // 물품 정보
		// TODO Auto-generated method stub
		return "[물품번호=" + no + ", 물품이름=" + title + ", 물품코드=" + code + ", 가격=" + price + ", 생산지= " + area + ", 수량=" + amount + ", 성인용품=" + adult + ", 유통기한=" + date + "]";
	}
	
	

}
