package chap14.sec03;

import java.util.*;

public class ProductStorage {
	private List<Product> list = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);
	private int counter;
	
	public void showMenu() {
		String selectNo;
		StringBuilder sb = new StringBuilder();
		sb.append("----------------------\n");
		sb.append("1. ��� | 2. ��� | 3. ����\n");
		sb.append("----------------------\n");
		sb.append("���� : ");
		
		while(true) {
			System.out.print(sb);
			selectNo = scanner.nextLine();
			switch(selectNo) {
				case "1": registerProduct();
					break;
				case "2": showProducts();
					break;
				case "3": return;
					
			}
			
		}
	}
	
	public void registerProduct() {
		try {
			Product product = new Product();
			
			System.out.println("��ǰ�� ���� ���");
			String line = scanner.nextLine();
			
			String [] cont = line.split(" ");
			product.setPno(++counter);
			product.setName(cont[0]);
			product.setPrice(Integer.parseInt(cont[1]));
			product.setStock(Integer.parseInt(cont[2]));
			
			list.add(product);
		} catch(Exception e) {
			System.out.println("��� ����: " + e.getMessage());
		}
	}
	public void showProducts() {
		StringBuilder sb = new StringBuilder();
		for(Product p : list) {
			sb.append(p.getPno() + "\t");
			sb.append(p.getName() + "\t");
			sb.append(p.getPrice() + "\t");
			sb.append(p.getStock() + "\n");
		}
		System.out.print(sb);
		
	}

}
