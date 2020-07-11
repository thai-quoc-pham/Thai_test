/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PQThai
 */
public class quanlyluong {

    static Scanner in = new Scanner(System.in);
    static Calendar cal = Calendar.getInstance();

    static List<String> hoten = new ArrayList<>();
    static List<String> manv = new ArrayList<>();
    static List<String> namsinh = new ArrayList<>();
    static List<String> gioitinh = new ArrayList<>();
    static List<Integer> tuoi = new ArrayList<>();
    static List<String> diachi = new ArrayList<>();
    static List<String> chucvu = new ArrayList<>();
    static List<Integer> luong = new ArrayList<>();
    static int a, chon, gio, sp, gt, cv, tinhluong, nsinh, tinhtuoi, num;
    static String chk, checkname, checkms, checknumber, checknam, checkgt, checkvt, tim;

    public static void main(String[] args) {
        menu();
        do {
            System.out.println("-------------------------------------");
            System.out.print("Chọn số thứ tự để thực hiện thao tác:  ");
            chon = in.nextInt();
            switch (chon) {
                case 0:
                    System.out.println("Chương trình đã thoát");
                    System.exit(0);
                case 1:
                    System.out.println("Thêm nhân viên");
                    themnv();
                    break;
                case 2:
                    if (num == 0) {
                        System.out.println("Mời nhập danh sách nhân viên");
                        break;
                    }
                    System.out.println("Xem danh sách nhân viên");
                    xuatnv();
                    break;
                case 3:
                    if (num == 0) {
                        System.out.println("Mời nhập danh sách nhân viên");
                        break;
                    }
                    System.out.println("Sửa thông tin nhân viên");
                    suatt();
                    break;
                case 4:
                    if (num == 0) {
                        System.out.println("Mời nhập danh sách nhân viên");
                        break;
                    }
                    System.out.println("Xóa nhân viên");
                    xoanv();
                    break;
                case 5:
                    if (num == 0) {
                        System.out.println("Mời nhập danh sách nhân viên");
                        break;
                    }
                    System.out.println("Tìm nhân viên");
                    sreach();
                    break;
                case 6:
                    if (num == 0) {
                        System.out.println("Mời nhập danh sách nhân viên");
                        break;
                    }
                    System.out.println("Xem bảng lương theo thứ tự tăng dần");
                    sapxeptang();
                    xuatnv();
                    break;
                case 7:
                    if (num == 0) {
                        System.out.println("Mời nhập danh sách nhân viên");
                        break;
                    }
                    System.out.println("Xem bảng lương theo thứ tự giảm dần");
                    sapxepgiam();
                    xuatnv();
                    break;
                default:
                    System.out.println("Nhập đúng số thứ tự để thực hiện thao tác");
            }
        } while (chon != 0);
    }

    static void menu() {
        System.out.println("------------------------------------------");
        System.out.println("|            Quản lý trả lương           |");
        System.out.println("|----------------------------------------|");
        System.out.println("| 1. Thêm nhân viên                      |");
        System.out.println("| 2. Xem danh sách nhân viên             |");
        System.out.println("| 3. Sửa thông tin nhân viên             |");
        System.out.println("| 4. Xóa nhân viên                       |");
        System.out.println("| 5. Tìm nhân viên                       |");
        System.out.println("| 6. Xem bảng lương theo thứ tự tăng dần |");
        System.out.println("| 7. Xem bảng lương theo thứ tự giảm dần |");
        System.out.println("| 0. Thoát chương trình                  |");
        System.out.println("------------------------------------------");
        System.out.println("");
    }

    //thêm nhân viên
    static void themnv() {

        System.out.print("Bạn muốn thêm bao nhiêu nhân viên:  ");
        checknumber = in.nextLine();
        checknumber();

        for (int i = 1; i <= num; i++) {
            System.out.println("----------------------------------");
            System.out.println("Nhập thông tin nhân viên thứ " + i);
            //mã nv
            System.out.println("Mã số nhân viên:" + "\n Tối đa 6 ký tự.");
            checkms = in.nextLine();
            nhapms();
            manv.add(checkms);
            //họ tên
            System.out.println("Họ và Tên:  " + "\n Tối thiểu 2 từ, tối đa 6 từ và nhập không dấu. VD: Pham Quoc Thai");
            checkname = in.nextLine();
            nhapten();
            hoten.add(checkname);
            //giới tính
            System.out.println("Giới tính: \t 1. Nam  \t 2.Nữ");
            System.out.print("Nhập số thứ tự để chọn giới tính:  ");
            do {
                checkgt = in.nextLine();
                checkgt();

                if (gt == 1 || gt == 2) {
                    if (gt == 1) {
                        gioitinh.add("Nam");
                        break;
                    }
                    if (gt == 2) {
                        gioitinh.add("Nu");
                        break;
                    }
                } else {
                    System.out.println("Nhập không hợp lệ");
                    System.out.println("Vui lòng nhập lại");
                }
            } while (true);
            //năm sinh
            System.out.print("Năm sinh:  ");
            checknam = in.nextLine();
            nhapns();
            namsinh.add(checknam);
            //tuổi
            nsinh = Integer.parseInt(checknam);
            tinhtuoi = cal.get(Calendar.YEAR) - nsinh;
            System.out.println("Tuổi:  " + tinhtuoi);
            tuoi.add(tinhtuoi);
            //địa chỉ
            System.out.print("Địa chỉ:  ");
            diachi.add(in.nextLine());
            //vị trí & lương
            System.out.println("Vị trí: \t 1: Quản lý \t 2: Công nhân làm theo giờ \t 3: Công nhân làm theo sản phẩm");
            System.out.print("Nhập số thứ tự để chọn vị trí:  ");
            do {
                checkvt = in.nextLine();
                checkvt();
                if (cv == 1 || cv == 2 || cv == 3) {
                    if (cv == 1) {
                        chucvu.add("quanly");
                        luong.add(15000000);
                        break;
                    }
                    if (cv == 2) {
                        chucvu.add("congnhanlamgio");
                        System.out.println("Tính lương: ");
                        System.out.print("Nhập số giờ làm việc:  ");
                        gio = in.nextInt();
                        if (gio <= 40) {
                            tinhluong = 20000 * gio;
                            luong.add(tinhluong);
                        } else {
                            tinhluong = (int) (20000 * 40 + 20000 * 1.5 * (gio - 40));
                            luong.add(tinhluong);
                        }
                        break;
                    }
                    if (cv == 3) {
                        chucvu.add("congnhansanpham");
                        System.out.println("Tính lương:");
                        System.out.print("Nhập số sản phẩm đã làm:  ");
                        sp = in.nextInt();
                        tinhluong = 10000 * sp;
                        luong.add(tinhluong);
                        break;
                    }

                } else {
                    System.out.println("Nhập không hợp lệ");
                }
            } while (true);
        }
    }

    //xuất nhân viên
    static void xuatnv() {
        for (int i = 0; i < manv.size(); i++) {
            System.out.println("--------------------");
            System.out.println("Mã NV: " + manv.get(i));
            System.out.println("Họ tên: " + hoten.get(i));
            System.out.println("Năm sinh: " + namsinh.get(i));
            System.out.println("Tuổi: " + tuoi.get(i));
            System.out.println("Giới tính: " + gioitinh.get(i));
            System.out.println("Địa chỉ: " + diachi.get(i));
            System.out.println("Vị trí: " + chucvu.get(i));
            System.out.println("Lương: " + luong.get(i));
        }
    }

    //sreach manv
    static void sreach() {
        System.out.println("Nhập mã NV:");
        tim = in.nextLine();
        checktimms();
        for (int i = 0; i < manv.size(); i++) {
            String check = manv.get(i);
            if (check.equals(tim)) {
                System.out.println("--------------------");
                System.out.println("Mã NV: " + manv.get(i));
                System.out.println("Họ tên: " + hoten.get(i));
                System.out.println("Năm sinh: " + namsinh.get(i));
                System.out.println("Tuổi: " + tuoi.get(i));
                System.out.println("Giới tính: " + gioitinh.get(i));
                System.out.println("Địa chỉ: " + diachi.get(i));
                System.out.println("Vị trí: " + chucvu.get(i));
                System.out.println("Lương: " + luong.get(i));
            } else {
                if ((i + 1) == manv.size()) {
                    System.out.println("Không tìm thấy nhân viên có mã: " + tim);
                } else {
                    System.out.println("Đang kiểm tra");
                }
            }

        }
    }

    //sửa thông tin nv
    static void suatt() {
        System.out.println("Nhập mã NV:");
        tim = in.nextLine();
        checktimms();
        for (int i = 0; i < manv.size(); i++) {
            String check = manv.get(i);
            if (check.equals(tim)) {
                //họ tên
                System.out.println("Họ và Tên:  " + "\n Tối thiểu 2 từ, tối đa 6 từ và nhập không dấu. VD: Pham Quoc Thai");
                checkname = in.nextLine();
                nhapten();
                hoten.set(i, checkname);
                //giới tính
                System.out.println("Giới tính: \t 1. Nam  \t 2.Nữ");
                System.out.print("Nhập số thứ tự để chọn giới tính:  ");
                do {
                    checkgt = in.nextLine();
                    checkgt();

                    if (gt == 1 || gt == 2) {
                        if (gt == 1) {
                            gioitinh.set(i, "Nam");
                            break;
                        }
                        if (gt == 2) {
                            gioitinh.set(i, "Nu");
                            break;
                        }
                    } else {
                        System.out.println("Nhập không hợp lệ");
                        System.out.println("Vui lòng nhập lại");
                    }
                } while (true);
                //năm sinh
                System.out.print("Năm sinh:  ");
                checknam = in.nextLine();
                nhapns();
                namsinh.set(i, checknam);
                //tuổi
                nsinh = Integer.parseInt(checknam);
                tinhtuoi = cal.get(Calendar.YEAR) - nsinh;
                System.out.println("Tuổi:  " + tinhtuoi);
                tuoi.set(i, tinhtuoi);
                //địa chỉ
                System.out.print("Địa chỉ:  ");
                diachi.set(i, in.nextLine());
                //vị trí & lương
                System.out.println("Vị trí: \t 1: Quản lý \t 2: Công nhân làm theo giờ \t 3: Công nhân làm theo sản phẩm");
                System.out.print("Nhập số thứ tự để chọn vị trí:  ");
                do {
                    checkvt = in.nextLine();
                    checkvt();
                    if (cv == 1 || cv == 2 || cv == 3) {
                        if (cv == 1) {
                            chucvu.set(i, "quanly");
                            luong.set(i, 15000000);
                            break;
                        }
                        if (cv == 2) {
                            chucvu.set(i, "congnhanlamgio");
                            System.out.println("Tính lương: ");
                            System.out.print("Nhập số giờ làm việc:  ");
                            gio = in.nextInt();
                            if (gio <= 40) {
                                tinhluong = 20000 * gio;
                                luong.set(i, tinhluong);
                            } else {
                                tinhluong = (int) (20000 * 40 + 20000 * 1.5 * (gio - 40));
                                luong.set(i, tinhluong);
                            }
                            break;
                        }
                        if (cv == 3) {
                            chucvu.set(i, "congnhansanpham");
                            System.out.println("Tính lương:");
                            System.out.print("Nhập số sản phẩm đã làm:  ");
                            sp = in.nextInt();
                            tinhluong = 10000 * sp;
                            luong.set(i, tinhluong);
                            break;
                        }

                    } else {
                        System.out.println("Nhập không hợp lệ");
                    }
                } while (true);
            } else {
                if ((i + 1) == manv.size()) {
                    System.out.println("Không tìm thấy nhân viên có mã: " + tim);
                } else {
                    System.out.println("Đang kiểm tra");
                }
            }
        }
    }

    //xóa nv
    static void xoanv() {
        System.out.println("Nhập mã NV:");
        tim = in.nextLine();
        checktimms();
        for (int i = 0; i < manv.size(); i++) {
            String check = manv.get(i);
            if (check.equals(tim)) {
                manv.remove(i);
                hoten.remove(i);
                namsinh.remove(i);
                tuoi.remove(i);
                gioitinh.remove(i);
                diachi.remove(i);
                chucvu.remove(i);
                luong.remove(i);
                System.out.println("Xóa thành công");
            } else {
                if ((i + 1) == manv.size()) {
                    System.out.println("Không tìm thấy nhân viên có mã: " + tim);
                } else {
                    System.out.println("Đang kiểm tra");
                }
            }
        }
    }

    //sắp xếp tăng dần
    static void sapxeptang() {
        for (int i = 0; i < luong.size() - 1; i++) {
            for (int j = i + 1; j < luong.size(); j++) {
                if (luong.get(i) > luong.get(j)) {
                    int tam = luong.get(i);
                    luong.set(i, luong.get(j));
                    luong.set(j, tam);

                    String matam = manv.get(i);
                    manv.set(i, manv.get(j));
                    manv.set(j, matam);

                    String tentam = hoten.get(i);
                    hoten.set(i, hoten.get(j));
                    hoten.set(j, tentam);

                    String nstam = namsinh.get(i);
                    namsinh.set(i, manv.get(j));
                    namsinh.set(j, nstam);

                    String gttam = gioitinh.get(i);
                    gioitinh.set(i, gioitinh.get(j));
                    gioitinh.set(j, gttam);

                    int tuoitam = tuoi.get(i);
                    tuoi.set(i, tuoi.get(j));
                    tuoi.set(j, tuoitam);

                    String dctam = diachi.get(i);
                    diachi.set(i, diachi.get(j));
                    diachi.set(j, dctam);

                    String cvtam = chucvu.get(i);
                    chucvu.set(i, chucvu.get(j));
                    chucvu.set(j, cvtam);
                }
            }

        }
    }
    
    //sắp xếp giảm
    static void sapxepgiam(){
        for (int i = 0; i < luong.size() - 1; i++) {
            for (int j = i + 1; j < luong.size(); j++) {
                if (luong.get(i) < luong.get(j)) {
                    int tam = luong.get(i);
                    luong.set(i, luong.get(j));
                    luong.set(j, tam);

                    String matam = manv.get(i);
                    manv.set(i, manv.get(j));
                    manv.set(j, matam);

                    String tentam = hoten.get(i);
                    hoten.set(i, hoten.get(j));
                    hoten.set(j, tentam);

                    String nstam = namsinh.get(i);
                    namsinh.set(i, manv.get(j));
                    namsinh.set(j, nstam);

                    String gttam = gioitinh.get(i);
                    gioitinh.set(i, gioitinh.get(j));
                    gioitinh.set(j, gttam);

                    int tuoitam = tuoi.get(i);
                    tuoi.set(i, tuoi.get(j));
                    tuoi.set(j, tuoitam);

                    String dctam = diachi.get(i);
                    diachi.set(i, diachi.get(j));
                    diachi.set(j, dctam);

                    String cvtam = chucvu.get(i);
                    chucvu.set(i, chucvu.get(j));
                    chucvu.set(j, cvtam);
                }
            }

        }
    }

    static String checktimms() {
        String chms = "[a-zA-Z0-9]{1,6}";
        boolean check = tim.matches(chms);
        if (check == true) {
            System.out.println("Vui lòng chờ");
        } else {
            System.out.println("Mã số không hợp lệ");
            System.out.print("Nhập lại mã số: ");
            tim = in.nextLine();
            checktimms();
        }
        return tim;
    }

    static String checknumber() {
        String number = "[0-9]{1}";
        boolean check = checknumber.matches(number);
        if (check == true) {
            num = Integer.parseInt(checknumber);
        }
        if (check == false) {
            System.out.println("Chỉ được nhập số");
            System.out.print("Vui lòng nhập: ");
            checknumber = in.nextLine();
            checknumber();
        }

        return checknumber;

    }

    //check name
    static String nhapten() {
        String chname = "[A-Za-z]{2,9}(\\s[A-Za-z]{2,9}){0,4}\\s[A-Za-z]{2,9}";
        boolean check = checkname.matches(chname);
        if (check == true) {
            System.out.println("Nhập thành công");
//            hoten.add(checkname);
        } else {
            System.out.println("Họ tên không hợp lệ");
            System.out.print("Nhập lại họ tên: ");
            checkname = in.nextLine();
            nhapten();
        }
        return checkname;
    }

    //check ms
    static String nhapms() {
        String chms = "[a-zA-Z0-9]{1,6}";
        boolean check = checkms.matches(chms);
        if (check == true) {
            checklap();
//            manv.add(checkms);
        } else {
            System.out.println("Mã số không hợp lệ");
            System.out.print("Nhập lại mã số: ");
            checkms = in.nextLine();
            nhapms();
        }
        return checkms;
    }

    //check lap ms
    static String checklap() {
        boolean lap = manv.contains(checkms);
        if (lap == false) {
            System.out.println("Nhập thành công");
        } else {
            System.out.println("Mã NV đã được sử dụng");
            checkms = in.nextLine();
            checklap();
        }
        return checkms;
    }

    //check NS
    static String nhapns() {
        String chnam = "[0-9]{4}";
        boolean check = checknam.matches(chnam);

        if (check == true) {
            System.out.println("Nhập thành công");
//            namsinh.add(checknam);
        } else {
            System.out.println("Năm sinh không hợp lệ");
            System.out.print("Nhập lại năm sinh: ");
            checknam = in.nextLine();
            nhapns();
        }
        return checknam;
    }

    //check giới tính
    static String checkgt() {
        String checkgioitinh = "[0-9]";

        boolean check = checkgt.matches(checkgioitinh);
        if (check == true) {
            gt = Integer.parseInt(checkgt);

        } else {
            System.out.println("Nhập không hợp lệ");
            System.out.print("Vui lòng nhập: ");
            checkgt = in.nextLine();
            checkgt();
        }
        return checkgt;
    }

    //check vt & lương
    static String checkvt() {
        String checkvitri = "[0-9]";
        boolean check = checkvt.matches(checkvitri);
        if (check == true) {
            cv = Integer.parseInt(checkvt);
        } else {
            System.out.println("Chỉ được nhập số");
            System.out.print("Vui lòng nhập: ");
            checkvt = in.nextLine();
            checkvt();
        }
        return checkvt;
    }

}
