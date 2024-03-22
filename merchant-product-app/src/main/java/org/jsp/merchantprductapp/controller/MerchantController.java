package org.jsp.merchantprductapp.controller;

import java.util.Scanner;
import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;


public class MerchantController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MerchantDao merchantDao = new MerchantDao();
		System.out.println("Press\n1. Save Merchant\n2. Update Merchant\n"
				+ "3. Find Merchant by Id\n4. Verify Merchant by phone\n5. verify Merchant By Email");
		System.out.print("Press number:- ");
		switch (sc.nextInt()) {
		case 1: {
			Merchant merchant = new Merchant();
			System.out.print("Enter the name :-");
			merchant.setName(sc.next());
			System.out.print("Enter the phone :-");
			merchant.setPhone(sc.nextLong());
			System.out.print("Enter the email :-");
			merchant.setEmail(sc.next());
			System.out.print("Enter the gst_number :-");
			merchant.setGst_number(sc.next());
			System.out.print("Enter the password :-");
			merchant.setPassword(sc.next());
			merchant = merchantDao.saveMerchant(merchant);
			System.out.println("Merchant saved with the id:- " + merchant.getId());
			break;

		}
		case 2:
			Merchant merchant = new Merchant();
			System.out.println("Enter the Merchant Id ");
			merchant.setId(sc.nextInt());
			System.out.print("Enter the name :-");
			merchant.setName(sc.next());
			System.out.print("Enter the phone :-");
			merchant.setPhone(sc.nextLong());
			System.out.print("Enter the email :-");
			merchant.setEmail(sc.next());
			System.out.print("Enter the gst_number :-");
			merchant.setGst_number(sc.next());
			System.out.print("Enter the password :-");
			merchant.setPassword(sc.next());
			merchant = merchantDao.updateMerchant(merchant);
			if (merchant != null) {
				System.out.println("Merchant Updated with the id:- " + merchant.getId());
			} else {
				System.err.println("Invalid Merhcant ID ");
			}
			System.out.println("Merchant Updated with the id:- " + merchant.getId());
			break;
		case 3:
			System.out.print("Enter the id of the merchant:- ");
			int mid = sc.nextInt();
			Merchant mrid = merchantDao.findMerchantById(mid);
			if (mrid != null) {
				System.out.println(mrid);
			}
			System.err.println("Invalid id");
			break;

		case 4:
			System.out.print("Enter the phone of the merchant:- ");
			long phone = sc.nextLong();
			System.out.print("Enter the passowrd of the merchant:- ");
			String pass = sc.next();
			Merchant merchant2 = merchantDao.verifyMerchant(phone, pass);
			if (merchant2 != null) {
				System.out.println(merchant2);
			} else {
				System.err.println("Invalid phone or Password");
			}
			break;
		case 5:
			System.out.print("Enter the Email of the merchant:- ");
			String email = sc.next();
			System.out.print("Enter the passowrd of the merchant:- ");
			String password = sc.next();
			Merchant data = merchantDao.verifyMerchant(email, password);
			if (data != null) {
				System.out.println(data);
			} else {
				System.err.println("Invalid phone or Password");
			}
			break;
		default:
			System.out.println("Invalid choice");

		}
		sc.close();
	}

}