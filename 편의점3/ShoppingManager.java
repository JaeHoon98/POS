package 편의점3;

public class ShoppingManager {
	private static ShoppingManager instance;
	public static ShoppingManager getInstance() {
		if(instance == null)
			instance = new ShoppingManager();
		return instance;
		
	}
	
	private Shopping[] sh;
	private int MAX_SIZE = 100;
	private int idx;
	
	private ShoppingManager() {
		sh = new Shopping[MAX_SIZE];
		idx = 0;
	}
	
	public void add(String no, String title, int code,  int price, String area, int amount, String adult, int date) {                      //물품등록 메소드
		Shopping s = new Shopping();
		s.setNo(no);
		s.setTitle(title);
		s.setCode(code);
		s.setPrice(price);
		s.setArea(area);
		s.setAmount(amount);
		s.setAdult(adult);
		s.setDate(date);
		
		sh[idx++] = s;
	}
	
	public void remove(String no) {                                                                                            //물품폐기 메소드
		for(int i=0; i<idx; i++) {
			if(sh[i].getNo().equals(no)) {
				for(;i<idx; i++) {
					sh[i] = sh[i+1];
				}
				idx--;
			}
		}
	}
	
	public void list() {                                                                                                     //물품목록 메소드
		System.out.println("=====================================");
		for(int i=0; i<idx; i++)
			System.out.println(sh[i]);
		
		System.out.println("=====================================");
	}
	
	public void search(String title) {                                                                                        //물품검색 메소드
		for(int i=0; i<idx; i++) {
			if(sh[i].getTitle().equals(title)) {
				System.out.println(sh[i]);
			}
		}
	}
	
	public void update(String title, int num) {                                                                              //판매후 재고 업데이트 메소드
		for(int i=0; i<idx; i++) {
			if((sh[i].getTitle().equals(title))) {
		if((sh[i].getAmount()==0) || (sh[i].getAmount()-num) < 0) {
			System.out.println("재고가 없습니다.");
			
		}else {
			sh[i].setAmount((sh[i].getAmount()-num));
			System.out.println("구매가 완료되었습니다.");
		}
		
	}

}
}
}


