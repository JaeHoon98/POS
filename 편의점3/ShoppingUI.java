package 편의점3;

import java.util.*;

public class ShoppingUI {
	
	Scanner sc = new Scanner(System.in);
	ShoppingManager sm = ShoppingManager.getInstance();
	
	int se1, sel2, sel3;
	String loginid = "";
	String loginps = "";
	long start = System.currentTimeMillis();
	long end = System.currentTimeMillis();
	public void totalService() {                                                   //첫화면
		while(true) {
			System.out.println("=============사용자==============");
			System.out.println("1. 판매자");
			System.out.println("2. 구매자");
			System.out.println("3. 종료하기");
			System.out.print("입력 > ");
			int sel = sc.nextInt();
			if(sel==1) {
				loginid();
			}else if(sel==2) {
				buyerService();
			}else if(sel==3) {
				quit();
			}
		}
	}
	
	public void quit() {                                                           //종료 메소드
		long end = System.currentTimeMillis();
		System.out.println("근무시간: " + (end - start)/1000.0 + "초");
		if((end - start)/1000.0/3600*9800 < 9800) {
			System.out.println("급료 : 0원");
		}else{
			System.out.println("급료 :" + (end - start)/1000.0/3600*9800 + "원");
		}
		System.out.println("=============오늘 하루도 수고하셨습니다.==============");
		System.exit(0);
	}
	
	public void loginid() {                                                        //아이디 메소드
		while(true){
	    System.out.println("=============로그인==============");
	    System.out.println("아이디 :");
	    sc.nextLine();
	    loginid = sc.nextLine();
	    if(loginid.equals("ok95124")) {
	    	loginps();
	    }else {
	    	System.out.println("아이디가 잘못되었습니다.");
	    }
	}
}
	
	public void loginps() {                                                        //비밀번호 메소드
		while(true){
			System.out.println("비밀번호 :");
			loginps = sc.nextLine();
			if(loginps.equals("okm95124")) {
				System.out.println("=============로그인 성공==============");
				sellerService();
			}else {
				System.out.println("=============로그인 실패==============");
				System.out.println("비밀번호가 잘못되었습니다.");
			}
		}
	}
	
	
	public void sellerService() {                                                  //판메자 메소드
		
		do {
			
		System.out.println("=============판매자 메뉴==============");
		System.out.println("1.물품 등록");
		System.out.println("2.물품 삭제");
		System.out.println("3.물품 목록");
		System.out.println("4.물품 검색");
		System.out.println("5.예상 급료");
		System.out.println("6.뒤로 가기");
		System.out.println("=======================================");
		
		sel2 = sc.nextInt();
		
		if(sel2==1) {                                                           //물품등록
			System.out.println("=============물품 등록==============");
			System.out.println("아래 사항을 입력하세요.");
			
			System.out.println("물품 번호 :");
			String no = sc.next();
			
			System.out.println("물품 이름 :");
			String info = sc.next();
			
			System.out.println("물품 코드 :");
			int code = sc.nextInt();
			
			System.out.println("물품 가격 :");
			int price = sc.nextInt();
			
			System.out.println("물품 생산지 :");
			String area = sc.next();
			
			System.out.println("물품 수량 :");
			int amount = sc.nextInt();
			
			System.out.println("성인용 물품 여부 Y/N :");
			String adult = sc.next();
			
			System.out.println("유통 기한 :");
			int date = sc.nextInt();
			
			sm.add(no, info, code, price, area, amount, adult, date);
		}else if(sel2==2) {                                                     //물품삭제
			System.out.println("=============물품 삭제==============");
			System.out.println("삭제할 물품 번호를 입력하세요.");
			sc.nextLine();
			String no = sc.nextLine();
			System.out.println("=====================================");
			sm.remove(no);
			
		}else if(sel2==3) {                                                     //물품목록
			sm.list();
			
		}else if(sel2==4) {                                                     //물품검색
			System.out.println("=============물품 검색==============");
			System.out.println("검색할 물품이름을 입력하세요.");
			sc.nextLine();
			String title = sc.nextLine();
			System.out.println("=====================================");
			sm.search(title);
			
		}else if(sel2==5) {                                                     //예상급료
			System.out.println("=============예상 급료==============");
			if((end - start)/1000.0/3600*9800 < 9800) {
				System.out.println("급료 : 0원");
			}else{
				System.out.println("예상급료 :" + (end - start)/1000.0/3600*9800 + "원");
			}
			
		}else if(sel2==6) {                                                     //뒤로가기
			totalService();
			
		}
	}while(sel2!=0);
}
public void buyerService() {                                                    //구매자메소드
	int age;
	do {
	System.out.println("=============나이 입력==============");                   //나이 입력
	age = sc.nextInt();
	if(age <= 19) {
		System.out.println("성인용 물품은 구매하실 수 없습니다.");
	}
		System.out.println("=============물품 구매==============");
		System.out.println("1.구매하기");
		System.out.println("2.뒤로가기");
		System.out.println("=====================================");
		sel3 = sc.nextInt();
		if(sel3==1) {                                                          //구매하기//카드, 현금 결제방식선택
			System.out.println("=====================================");
			System.out.println("구매할 물품의 이름을 입력하세요.");
			sc.nextLine();
			String title = sc.nextLine();
			sm.search(title);
			
			System.out.print("구매할 갯수를 입력하세요:");
			int num = sc.nextInt();
			sm.update(title, num);
			totalService();
			
		}if(sel3==2) {                                                          //뒤로가기
			totalService();
		}
}while(sel3!=0);
	
}
}






